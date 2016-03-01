package SpongeCity.MonitorPlatform.DBAccess.Interface;

import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataTypeModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceTypeModel;

import java.util.List;
import java.util.Map;

/**
 * Created by sabermai on 2016/1/13.
 */
public interface IDataTypeOperation {
    List<DB_DataTypeModel> getDataTypeList();
    List<DB_DataTypeModel> getDataTypeListByDeviceId(Map params);
}
