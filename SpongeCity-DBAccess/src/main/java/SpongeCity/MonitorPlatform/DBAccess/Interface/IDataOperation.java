package SpongeCity.MonitorPlatform.DBAccess.Interface;

import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataModel;

import java.util.List;
import java.util.Map;

/**
 * Created by sabermai on 2016/1/8.
 */
public interface IDataOperation {
    List<DB_DataModel> getDataByDataTypeandArea(Map params);

    List<DB_DataModel> getDataByDataTypeAreaAndTime(Map params);

    List<DB_DataModel> getDataByArea(String areaIds);

    List<DB_DataModel> getDataByDataTypeAndDeviceId(Map params);

    List<DB_DataModel> getDataByDeviceId(Map params);

    List<DB_DataModel> getDataByDeviceIdandDtId(Map params);
}
