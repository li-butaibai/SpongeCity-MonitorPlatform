package SpongeCity.MonitorPlatform.DBAccess.DataAccess;

import SpongeCity.MonitorPlatform.DBAccess.Common.SqlConnection;
import SpongeCity.MonitorPlatform.DBAccess.Interface.IDeviceOperation;
import SpongeCity.MonitorPlatform.DBAccess.Interface.IDeviceTypeOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceTypeModel;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public class DeviceDA {
    public List<DB_DeviceTypeModel> getAllDeviceType() {
        SqlSession session = SqlConnection.getSession();
        try {
            IDeviceTypeOperation deviceTypeOperation = session.getMapper(IDeviceTypeOperation.class);
            List<DB_DeviceTypeModel> types = deviceTypeOperation.getAllDeviceType();
            return types;
        } finally {
            session.close();
        }
    }

    public List<DB_DeviceModel> getAllDevices() {
        SqlSession session = SqlConnection.getSession();
        try {
            IDeviceOperation deviceOperation = session.getMapper(IDeviceOperation.class);
            List<DB_DeviceModel> devices = deviceOperation.getAllDevice();
            return devices;
        } finally {
            session.close();
        }
    }

    public DB_DeviceModel getDeviceById(int deviceId) {
        SqlSession session = SqlConnection.getSession();
        try {
            IDeviceOperation deviceOperation = session.getMapper(IDeviceOperation.class);
            DB_DeviceModel device = deviceOperation.getDeviceById(deviceId);
            return device;
        } finally {
            session.close();
        }
    }

    //get device list in current area and all sub area
    public List<DB_DeviceModel> getAllDeviceByAreaId(int areaId) {
        SqlSession session = SqlConnection.getSession();
        try {
            List<DB_DeviceModel> devices = new ArrayList<DB_DeviceModel>();
            AreaDA ad = new AreaDA();
            List<DB_AreaModel> areas = ad.getAreaAllChildren(areaId);
            areas.add(ad.getAreaById(areaId));
            IDeviceOperation deviceOperation = session.getMapper(IDeviceOperation.class);
            String areaIds = "";
            for (DB_AreaModel area : areas) {
                areaIds += area.getId() + ",";
            }
            devices.addAll(deviceOperation.getDeviceListByAreaId(areaIds.substring(0, areaIds.length() - 1)));
            return devices;
        } finally {
            session.close();
        }
    }

    //get device list in current area
    public List<DB_DeviceModel> getDevicesByCurrentAreaId(int areaId) {
        SqlSession session = SqlConnection.getSession();
        try {
            List<DB_DeviceModel> devices = new ArrayList<DB_DeviceModel>();
            IDeviceOperation deviceOperation = session.getMapper(IDeviceOperation.class);
            devices = deviceOperation.getDeviceListByAreaId(Integer.toString(areaId));
            return devices;
        } finally {
            session.close();
        }
    }

    /*public List<DB_DeviceModel> getDevicesWithData(int dataTypeId){
    }*/
}
