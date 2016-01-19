import SpongeCity.MonitorPlatform.Core.PlatformData.AreaDataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DeviceDataOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceModel;
import Util.DeviceDataFileWriter;
import Util.ModelConverter;
import controllers.DataController;
import models.DataModel;
import models.DeviceModel;

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
        DataController controller = new DataController();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            controller.getDeviceData(1, 1,sdf.parse("2016/01/04"), sdf.parse("2016/01/08"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
