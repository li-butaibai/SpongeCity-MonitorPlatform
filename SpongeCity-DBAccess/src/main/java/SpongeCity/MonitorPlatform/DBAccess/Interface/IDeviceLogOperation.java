package SpongeCity.MonitorPlatform.DBAccess.Interface;

import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceLogModel;

import java.util.List;
import java.util.Map;

/**
 * Created by saber on 2016/1/4.
 */
public interface IDeviceLogOperation {
    List<DB_DeviceLogModel> getDeviceLogByDeviceId(int deviceId);

    List<DB_DeviceLogModel> getLastDeviceLogByDeviceId(Map<String, Integer> params);
}
