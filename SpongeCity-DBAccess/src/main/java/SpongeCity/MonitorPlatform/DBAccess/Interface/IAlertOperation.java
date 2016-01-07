package SpongeCity.MonitorPlatform.DBAccess.Interface;

import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AlertModel;

import java.util.List;
import java.util.Map;

/**
 * Created by sabermai on 2016/1/5.
 */
public interface IAlertOperation {
    List<DB_AlertModel> getAlertList(Map params);

    //List<DB_AlertModel> getAlertListByDeviceId(Map params);
    List<DB_AlertModel> getAlertListByDeviceId(int deviceId);

    List<DB_AlertModel> getAllAlertByAreaId(Map params);

    DB_AlertModel getAlertInfo(int alertId);
}
