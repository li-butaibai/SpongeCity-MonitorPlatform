package SpongeCity.MonitorPlatform.DBAccess.Interface;

import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public interface IDeviceOperation {
    List<DB_DeviceModel> getAllDevice();

    DB_DeviceModel getDeviceById(int deviceId);

    List<DB_DeviceModel> getDeviceListByAreaId(String areaIds);

    List<DB_DeviceModel> getDeviceListByDeviceType(int devicetype_id);

    List<DB_DeviceModel> getDeviceListByDeviceTypeAndAreaId(@Param("areaId")int areaId, @Param("devicetypeId")int devicetypeId);
}
