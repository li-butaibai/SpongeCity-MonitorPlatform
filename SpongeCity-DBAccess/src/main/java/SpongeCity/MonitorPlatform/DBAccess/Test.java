package SpongeCity.MonitorPlatform.DBAccess;

import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AlertData;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AreaData;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DeviceData;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        AreaData ad = new AreaData();
        List<DB_AreaModel> areas = ad.getAreaAllChildren(1);
        areas = ad.getAreaAllChildren(1);
    }
}
