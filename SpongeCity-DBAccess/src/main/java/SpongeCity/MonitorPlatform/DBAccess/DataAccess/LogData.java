package SpongeCity.MonitorPlatform.DBAccess.DataAccess;

import SpongeCity.MonitorPlatform.DBAccess.Common.SqlConnection;
import SpongeCity.MonitorPlatform.DBAccess.Interface.IDeviceLogOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceLogModel;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by saber on 2016/1/4.
 */
public class LogData {
    public List<DB_DeviceLogModel> getDeviceLogByDeviceId(int deviceId) {
        SqlSession session = SqlConnection.getSession();
        try {
            IDeviceLogOperation logOperation = session.getMapper(IDeviceLogOperation.class);
            List<DB_DeviceLogModel> logs = logOperation.getDeviceLogByDeviceId(deviceId);
            return logs;
        } finally {
            session.close();
        }
    }
}
