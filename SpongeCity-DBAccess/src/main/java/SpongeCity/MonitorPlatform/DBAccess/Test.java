package SpongeCity.MonitorPlatform.DBAccess;

import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AlertDA;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AreaDA;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DataDA;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DeviceDA;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AlertModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceTypeModel;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        DeviceDA dda = new DeviceDA();
        try {
            List<DB_DeviceTypeModel> list = dda.getAllDeviceType();
            for (DB_DeviceTypeModel db_deviceTypeModel : list) {
                System.out.println(db_deviceTypeModel.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
