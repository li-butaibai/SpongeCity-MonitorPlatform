package SpongeCity.MonitorPlatform.DBAccess.DataAccess;

import SpongeCity.MonitorPlatform.DBAccess.Common.BatisConnection;
import SpongeCity.MonitorPlatform.DBAccess.Interface.IDeviceLogOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceLogModel;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by saber on 2016/1/4.
 */
public class LogDA {
    public List<DB_DeviceLogModel> getDeviceLogByDeviceId(int deviceId) {
        SqlSession session = BatisConnection.getSession();
        try {
            IDeviceLogOperation logOperation = session.getMapper(IDeviceLogOperation.class);
            List<DB_DeviceLogModel> logs = logOperation.getDeviceLogByDeviceId(deviceId);
            return logs;
        } finally {
            session.close();
        }
    }

    public List<DB_DeviceLogModel> getLastDeviceLogByDeviceId(int deviceId, int itemCount) {
        SqlSession session = BatisConnection.getSession();
        try {
            IDeviceLogOperation logOperation = session.getMapper(IDeviceLogOperation.class);
            Map<String, Integer> params = new HashMap<String, Integer>();
            params.put("deviceId",deviceId);
            params.put("itemCount",itemCount);
            List<DB_DeviceLogModel> logs = logOperation.getLastDeviceLogByDeviceId(params);
            return logs;
        } finally {
            session.close();
        }
    }
}
