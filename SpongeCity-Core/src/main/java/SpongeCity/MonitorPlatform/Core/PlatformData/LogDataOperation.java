package SpongeCity.MonitorPlatform.Core.PlatformData;

import SpongeCity.MonitorPlatform.DBAccess.DataAccess.LogData;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceLogModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public class LogDataOperation {
    public List<DB_DeviceLogModel> getDeviceLogList(int deviceId) {
        List<DB_DeviceLogModel> deviceLogList = new ArrayList<DB_DeviceLogModel>();
        try {
            LogData ld = new LogData();
            deviceLogList = ld.getDeviceLogByDeviceId(deviceId);
        }catch (Exception ex){
            //log
        }
        return deviceLogList;
    }
}
