package SpongeCity.MonitorPlatform.Core.PlatformData;

import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DeviceData;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceTypeModel;

import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public class DeviceDataOperation {
    private DeviceData dd = new DeviceData();

    public List<DB_DeviceTypeModel> getAllDeviceType() {
        List<DB_DeviceTypeModel> deviceTypeList = dd.getAllDeviceType();
        return deviceTypeList;
    }

    public List<DB_DeviceModel> getAllDevice() {
        List<DB_DeviceModel> deviceList = dd.getAllDevices();
        return deviceList;
    }

    public DB_DeviceModel getDeviceInfo(int deviceId) {
        DB_DeviceModel device = new DB_DeviceModel();
        device = dd.getDeviceById(deviceId);
        return device;
    }
}
