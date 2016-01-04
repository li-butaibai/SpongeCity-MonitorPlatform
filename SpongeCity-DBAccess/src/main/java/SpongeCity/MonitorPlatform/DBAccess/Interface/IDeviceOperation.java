package SpongeCity.MonitorPlatform.DBAccess.Interface;

import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceModel;

import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public interface IDeviceOperation {
    List<DB_DeviceModel> getAllDevice();

    DB_DeviceModel getDeviceById(int deviceId);
}
