import SpongeCity.MonitorPlatform.Core.PlatformData.AreaDataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DataOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataModel;
import Util.DeviceDataFileWriter;
import Util.ModelConverter;
import controllers.DataController;
import models.DataModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sabermai on 2016/1/12.
 */
public class Test {
    public static void main(String[] args) {
        try {
            DataController dc = new DataController();
            List<Integer> datatypes = new ArrayList<Integer>();
            datatypes.add(1);
            datatypes.add(2);
            datatypes.add(4);
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            dc.getDeviceDetail(1, ft.parse("2016-01-01"), ft.parse("2016-01-31"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
