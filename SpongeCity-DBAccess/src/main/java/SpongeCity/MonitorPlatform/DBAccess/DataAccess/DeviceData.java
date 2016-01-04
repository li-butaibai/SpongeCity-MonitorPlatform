package SpongeCity.MonitorPlatform.DBAccess.DataAccess;

import SpongeCity.MonitorPlatform.DBAccess.Common.SqlConnection;
import SpongeCity.MonitorPlatform.DBAccess.Interface.IDeviceTypeOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceTypeModel;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public class DeviceData {
    private static SqlSession session = SqlConnection.getSession().openSession();

    public List<DB_DeviceTypeModel> getAllDeviceType(){
        try {
            IDeviceTypeOperation deviceTypeOperation = session.getMapper(IDeviceTypeOperation.class);
            List<DB_DeviceTypeModel> types = deviceTypeOperation.getAllDeviceType();
            return types;
        } finally {
            session.close();
        }
    }
}
