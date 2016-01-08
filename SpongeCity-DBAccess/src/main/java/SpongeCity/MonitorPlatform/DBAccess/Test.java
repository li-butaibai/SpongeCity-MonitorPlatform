package SpongeCity.MonitorPlatform.DBAccess;

import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AlertData;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AreaData;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DeviceData;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AlertModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        AlertData al = new AlertData();
        List<DB_AreaModel> areas = new ArrayList<DB_AreaModel>();
        AreaData areaData = new AreaData();
        areas = areaData.getAreaAllChildren(1);
        areas.add(areaData.getAreaById(1));
        List<DB_AlertModel> alertList = al.getAllAlertByAreaList(areas, 3, 10);
    }
}
