package SpongeCity.MonitorPlatform.Core.PlatformData;

import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AlertData;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DeviceData;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AlertModel;
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
        alertList = ad.getAlertList(pageIndex, pageSize);
        return alertList;
    }

    public List<DB_AlertModel> getAlertListByDeviceId(int deviceId, int pageIndex, int pageSize) {
        List<DB_AlertModel> alertList = new ArrayList<DB_AlertModel>();
        alertList = ad.getAlertListByDeviceId(deviceId, pageIndex, pageSize);
        return alertList;
    }

    public List<DB_AlertModel> getAreaAlertList(int areaId, int pageIndex, int pageSize) {
        List<DB_AlertModel> alertList = new ArrayList<DB_AlertModel>();
        List<DB_DeviceModel> devices = new ArrayList<DB_DeviceModel>();
        devices = dd.getAllDeviceByAreaId(areaId);

        return alertList;
    }

    public DB_AlertModel getAlertInfo(int alertId) {
        DB_AlertModel alert = new DB_AlertModel();
        alert = ad.getAlertInfoByAlertId(alertId);
        return alert;
    }
}
