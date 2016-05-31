package SpongeCity.MonitorPlatform.DBAccess;

import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AlertDA;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AreaDA;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DataDA;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DeviceDA;
import SpongeCity.MonitorPlatform.DBAccess.Model.*;

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
        try {
            List<DB_DataTypeModel> types = dda.getDataTypeListByDeviceTypeId(1);
            System.out.println(types.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
