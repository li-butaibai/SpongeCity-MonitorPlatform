package SpongeCity.MonitorPlatform.DBAccess.DataAccess;

import SpongeCity.MonitorPlatform.DBAccess.Common.SqlConnection;
import SpongeCity.MonitorPlatform.DBAccess.Interface.IDataOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataModel;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sabermai on 2016/1/8.
 */
public class DataDA {
    public List<DB_DataModel> getDataByDataypeandArea(int dataTypeid, int areaId) {
        SqlSession session = SqlConnection.getSession();
        try {
            Map<String, Integer> params = new HashMap<String, Integer>();
            params.put("dataTypeid", dataTypeid);
            params.put("areaId", areaId);
            IDataOperation dataOperation = session.getMapper(IDataOperation.class);
            List<DB_DataModel> datas = dataOperation.getDataByDataTypeandArea(params);
            return datas;
        } finally {
            session.close();
        }
    }

    public List<DB_DataModel> getDataByDataTypeAreaAndTime(int dataTypeid, int areaId, Date startTime, Date endTime) {
        SqlSession session = SqlConnection.getSession();
        try {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("dataTypeid", dataTypeid);
            params.put("areaId", areaId);
            params.put("startTime", "'" + ft.format(startTime) + "'");
            params.put("endTime", "'" + ft.format(endTime) + "'");
            IDataOperation dataOperation = session.getMapper(IDataOperation.class);
            List<DB_DataModel> datas = dataOperation.getDataByDataTypeAreaAndTime(params);
            return datas;
        } finally {
            session.close();
        }
    }
}
