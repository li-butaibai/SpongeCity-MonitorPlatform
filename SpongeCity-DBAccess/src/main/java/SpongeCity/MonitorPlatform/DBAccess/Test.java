package SpongeCity.MonitorPlatform.DBAccess;

import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AlertDA;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AreaDA;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DataDA;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DeviceDA;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AlertModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;

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
        DataDA dda = new DataDA();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            dda.getDataByDataTypeAndDeviceId(1,1,sdf.parse("2016/01/04"), sdf.parse("2016/01/08"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
