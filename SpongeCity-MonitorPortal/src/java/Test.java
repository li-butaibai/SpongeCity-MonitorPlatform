import SpongeCity.MonitorPlatform.Core.PlatformData.AreaDataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DataOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataModel;
import Util.DeviceDataFileWriter;
import Util.ModelConverter;
import controllers.DataController;
import models.DataModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sabermai on 2016/1/12.
 */
public class Test {
    public static void main(String[] args) {
        DataController dc = new DataController();
        List<Integer> datatypes = new ArrayList<Integer>();
        datatypes.add(1);
        datatypes.add(2);
        datatypes.add(4);
        dc.getDataByAreaAndDataType(1,datatypes);
    }
}
