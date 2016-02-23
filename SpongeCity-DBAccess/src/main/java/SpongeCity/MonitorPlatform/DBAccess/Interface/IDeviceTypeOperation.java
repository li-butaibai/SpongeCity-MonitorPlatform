package SpongeCity.MonitorPlatform.DBAccess.Interface;

import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceTypeModel;

import java.util.List;
import java.util.Map;

/**
 * Created by sabermai on 2016/1/4.
 */
public interface IDeviceTypeOperation {
    List<DB_DeviceTypeModel> getAllDeviceType();

}
