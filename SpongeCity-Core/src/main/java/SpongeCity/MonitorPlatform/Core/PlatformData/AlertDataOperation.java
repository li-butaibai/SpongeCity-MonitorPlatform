package SpongeCity.MonitorPlatform.Core.PlatformData;

import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AlertData;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AreaData;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DeviceData;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AlertModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public class AlertDataOperation {
    private AlertData ad = new AlertData();
    private DeviceData dd = new DeviceData();

    public List<DB_AlertModel> getAlertList(int pageIndex, int pageSize) {
        List<DB_AlertModel> alertList = new ArrayList<DB_AlertModel>();
        try {
            alertList = ad.getAlertList(pageIndex, pageSize);
        }catch (Exception ex){
            //log
        }
        return alertList;
    }

    public List<DB_AlertModel> getAlertListByDeviceId(int deviceId) {
        List<DB_AlertModel> alertList = new ArrayList<DB_AlertModel>();
        try {
            alertList = ad.getAlertListByDeviceId(deviceId);
        }catch (Exception ex){
            //log
        }
        return alertList;
    }

    public List<DB_AlertModel> getAreaAlertList(int areaId, int pageIndex, int pageSize) {
        List<DB_AlertModel> alertList = new ArrayList<DB_AlertModel>();
        try {
            List<DB_AreaModel> areas = new ArrayList<DB_AreaModel>();
            AreaData areaData = new AreaData();
            areas = areaData.getAreaAllChildren(areaId);
            areas.add(areaData.getAreaById(areaId));
            alertList = ad.getAllAlertByAreaId(areas, pageIndex, pageSize);
        }catch (Exception ex){
            //log
        }
        return alertList;
    }

    public DB_AlertModel getAlertInfo(int alertId) {
        DB_AlertModel alert = new DB_AlertModel();
        try {
            alert = ad.getAlertInfoByAlertId(alertId);
        }catch (Exception ex){
            //log
        }
        return alert;
    }
}
