package SpongeCity.MonitorPlatform.Core.PlatformData;

import SpongeCity.MonitorPlatform.DBAccess.Model.AlertModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public class AlertData {
    public List<AlertModel> getAlertList(int pageIndex, int pageSize){
        List<AlertModel> alertList = new ArrayList<AlertModel>();

        return alertList;
    }

    public List<AlertModel> getDeviceAlertList(int deviceId, int pageIndex, int pageSize){
        List<AlertModel> alertList = new ArrayList<AlertModel>();

        return alertList;
    }

    public List<AlertModel> getAreaAlertList(int areaId, int pageIndex, int pageSize){
        List<AlertModel> alertList = new ArrayList<AlertModel>();

        return alertList;
    }

    public AlertModel getAlertInfo(int alertId){
        AlertModel alert = new AlertModel();

        return alert;
    }
}
