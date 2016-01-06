package SpongeCity.MonitorPlatform.Core.PlatformData;

import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AlertModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public class AlertDataOperation {
    public List<DB_AlertModel> getAlertList(int pageIndex, int pageSize){
        List<DB_AlertModel> alertList = new ArrayList<DB_AlertModel>();

        return alertList;
    }

    public List<DB_AlertModel> getDeviceAlertList(int deviceId, int pageIndex, int pageSize){
        List<DB_AlertModel> alertList = new ArrayList<DB_AlertModel>();

        return alertList;
    }

    public List<DB_AlertModel> getAreaAlertList(int areaId, int pageIndex, int pageSize){
        List<DB_AlertModel> alertList = new ArrayList<DB_AlertModel>();

        return alertList;
    }

    public DB_AlertModel getAlertInfo(int alertId){
        DB_AlertModel alert = new DB_AlertModel();

        return alert;
    }
}
