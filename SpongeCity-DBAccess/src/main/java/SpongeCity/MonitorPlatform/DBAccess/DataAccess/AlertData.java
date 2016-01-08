package SpongeCity.MonitorPlatform.DBAccess.DataAccess;

import SpongeCity.MonitorPlatform.DBAccess.Common.SqlConnection;
import SpongeCity.MonitorPlatform.DBAccess.Interface.IAlertOperation;
import SpongeCity.MonitorPlatform.DBAccess.Interface.IDeviceOperation;
import SpongeCity.MonitorPlatform.DBAccess.Interface.IDeviceTypeOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AlertModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceTypeModel;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sabermai on 2016/1/5.
 */
public class AlertData {
    public List<DB_AlertModel> getAlertList(int pageIndex, int pageSize) {
        SqlSession session = SqlConnection.getSession();
        try {
            Map<String, Integer> params = new HashMap<String, Integer>();
            params.put("pageSize", pageSize);
            params.put("itemIndex", (pageIndex - 1) * pageSize);
            IAlertOperation alertOperation = session.getMapper(IAlertOperation.class);
            List<DB_AlertModel> alerts = alertOperation.getAlertList(params);
            return alerts;
        } finally {
            session.close();
        }
    }

    public List<DB_AlertModel> getAlertListByDeviceId(int deviceId) {
        SqlSession session = SqlConnection.getSession();
        try {
            /*Map<String, Integer> params = new HashMap<String, Integer>();
            params.put("deviceId", deviceId);
            params.put("pageSize", pageSize);
            params.put("itemIndex", (pageIndex - 1) * pageSize);*/
            IAlertOperation alertOperation = session.getMapper(IAlertOperation.class);
            List<DB_AlertModel> alerts = alertOperation.getAlertListByDeviceId(deviceId);
            return alerts;
        } finally {
            session.close();
        }
    }

    public DB_AlertModel getAlertInfoByAlertId(int alertId) {
        SqlSession session = SqlConnection.getSession();
        try {
            IAlertOperation alertOperation = session.getMapper(IAlertOperation.class);
            DB_AlertModel alert = alertOperation.getAlertInfo(alertId);
            return alert;
        } finally {
            session.close();
        }
    }

    public List<DB_AlertModel> getAllAlertByAreaList(List<DB_AreaModel> areas, int pageIndex, int pageSize) {
        SqlSession session = SqlConnection.getSession();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            String strAreaIds = "";
            for (DB_AreaModel area : areas) {
                strAreaIds += area.getId() + ",";
            }
            params.put("areaIds", strAreaIds.substring(0, strAreaIds.lastIndexOf(",")));
            params.put("pageSize", pageSize);
            params.put("itemIndex", (pageIndex - 1) * pageSize);
            IAlertOperation alertOperation = session.getMapper(IAlertOperation.class);
            List<DB_AlertModel> alerts = alertOperation.getAllAlertByAreaId(params);
            return alerts;
        } finally {
            session.close();
        }
    }
}
