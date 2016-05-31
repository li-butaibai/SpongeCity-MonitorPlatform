package SpongeCity.MonitorPlatform.ScheduleTask;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by saber on 2016/5/30.
 */
public class RestApiHelper {
    //private static CloseableHttpClient client = HttpClients.createDefault();
    private CloseableHttpClient client;

    public JSONObject get(String url){
        try{
            client = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            httpget.addHeader("Authorization","Basic ZXRhZG1pbkBzaXRlOmFiY2QxMjM=");
            CloseableHttpResponse response = client.execute(httpget);
            try {
                HttpEntity entity = response.getEntity();
                JSONObject jsonObj = JSONObject.fromObject(EntityUtils.toString(entity));
                return jsonObj;
            }finally {
                response.close();
            }
        } catch (Exception e){
            return null;
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                //e.printStackTrace();
                return null;
            }
        }
    }
}
