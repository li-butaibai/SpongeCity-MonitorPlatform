package SpongeCity.MonitorPlatform.DBAccess.Interface;

import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;

import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public interface IAreaOperation {
    List<DB_AreaModel> getAllArea();

    DB_AreaModel getAreaById(int areaId);

    List<DB_AreaModel> getAreaChildren(int areaId);
}
