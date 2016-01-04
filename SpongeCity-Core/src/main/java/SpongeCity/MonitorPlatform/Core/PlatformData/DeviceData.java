package SpongeCity.MonitorPlatform.Core.PlatformData;

import SpongeCity.MonitorPlatform.DBAccess.Model.DeviceModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DeviceTypeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public class DeviceData {
    public List<DeviceTypeModel> getAllDeviceType() {
        List<DeviceTypeModel> deviceTypeList = new ArrayList<DeviceTypeModel>();

        return deviceTypeList;
    }

    public List<DeviceModel> getAllDevice(){
        List<DeviceModel> deviceList = new ArrayList<DeviceModel>();

        return deviceList;
    }

    public DeviceModel getDeviceInfo(int deviceId){
        DeviceModel device = new DeviceModel();

        return device;
    }
}
