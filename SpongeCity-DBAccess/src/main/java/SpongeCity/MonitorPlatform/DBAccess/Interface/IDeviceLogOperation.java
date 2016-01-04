package SpongeCity.MonitorPlatform.DBAccess.Interface;

import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceLogModel;

import java.util.List;

/**
 * Created by saber on 2016/1/4.
 */
public interface IDeviceLogOperation {
    List<DB_DeviceLogModel> getDeviceLogByDeviceId(int deviceId);
}
