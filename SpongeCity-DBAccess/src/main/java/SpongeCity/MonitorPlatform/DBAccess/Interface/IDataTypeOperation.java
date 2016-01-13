package SpongeCity.MonitorPlatform.DBAccess.Interface;

import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataTypeModel;

import java.util.List;

/**
 * Created by sabermai on 2016/1/13.
 */
public interface IDataTypeOperation {
    List<DB_DataTypeModel> getDataTypeList();
}
