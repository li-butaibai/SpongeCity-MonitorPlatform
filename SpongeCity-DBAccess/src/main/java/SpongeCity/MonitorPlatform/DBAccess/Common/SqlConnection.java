package SpongeCity.MonitorPlatform.DBAccess.Common;

import org.apache.ibatis.io.Resources;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by saber on 2016/3/14.
 */
public class SqlConnection {
    public static Connection getConnection() throws Exception {
        try {
            String url = "";
            String user = "";
            String pwd = "";
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputStream in = Resources.getResourceAsStream(Resources.getDefaultClassLoader(), "MybatisConfiguration.xml");
            //File file = Resources.getResourceAsFile("MybatisConnection.xml");
            Document document = db.parse(in);
            NodeList configs = null;
            NodeList nodes = document.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                if (nodes.item(i).getNodeName() == "configuration" && nodes.item(i).hasChildNodes()) {
                    configs = nodes.item(i).getChildNodes();
                    break;
                }
            }
            Node env = null;
            for (int i = 0; i < configs.getLength(); i++) {
                if (configs.item(i).getNodeName() == "environments") {
                    env = configs.item(i).getChildNodes().item(1);
                    break;
                }
            }
            NodeList envChildren = env.getChildNodes();
            Node datasource = null;
            for (int i = 0; i < envChildren.getLength(); i++) {
                if (envChildren.item(i).getNodeName() == "dataSource") {
                    datasource = envChildren.item(i);
                    break;
                }
            }
            NodeList dsChildren = datasource.getChildNodes();
            for (int i = 0; i < dsChildren.getLength(); i++) {
                Node proNode = dsChildren.item(i);
                if (proNode.hasAttributes()) {
                    NamedNodeMap nnm = dsChildren.item(i).getAttributes();
                    String property = nnm.getNamedItem("name").getNodeValue();
                    if (property.equalsIgnoreCase("url")) {
                        url = nnm.getNamedItem("value").getNodeValue();
                    } else if (property.equalsIgnoreCase("username")) {
                        user = nnm.getNamedItem("value").getNodeValue();
                    } else if (property.equalsIgnoreCase("password")) {
                        pwd = nnm.getNamedItem("value").getNodeValue();
                    }
                }
            }
            Connection conn = DriverManager.getConnection(url, user, pwd);
            return conn;
        } catch (Exception ex) {
            throw ex;
            /*Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assess", "root", "Passw0rd");
            return conn;*/
        }
    }

    public static int saveImportData(String cmd) throws Exception {
        try {
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assess", "root", "Passw0rd");//roll back
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(cmd);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
