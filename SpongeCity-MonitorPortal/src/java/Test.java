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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sabermai on 2016/1/12.
 */
public class Test {
    public static void main(String[] args) {
        DeviceDataOperation deviceDataOperation = new DeviceDataOperation();
        DB_DeviceModel db_deviceModel = deviceDataOperation.getDeviceInfo(1);
        ModelConverter converter = new ModelConverter();
        DeviceModel deviceModel = converter.convertDBDeviceModel2PortalDeviceModel(db_deviceModel);
    }
}
