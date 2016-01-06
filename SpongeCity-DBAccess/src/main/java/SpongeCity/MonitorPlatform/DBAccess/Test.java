package SpongeCity.MonitorPlatform.DBAccess;

import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AlertData;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DeviceData;

/**
 * Created by sabermai on 2016/1/4.
 */
public class Test {
    public static void main(String[] args) {
        AlertData ad = new AlertData();
        ad.getAlertListByDeviceId(2,1,20);
    }
}
