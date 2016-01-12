package Util;

import SpongeCity.MonitorPlatform.Core.PlatformData.AlertDataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.AreaDataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DeviceDataOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.*;
import models.*;

import java.util.List;

/**
 * Created by sabermai on 2016/1/11.
 */
public class ModelConverter {
    public DeviceModel convertDBDeviceModel2PortalDeviceModel(DB_DeviceModel db_deviceModel) {
        AlertDataOperation alertDataOperation = new AlertDataOperation();
        AreaDataOperation areaDataOperation = new AreaDataOperation();
        DeviceModel deviceModel = new DeviceModel();

        List<DB_AlertModel> alerts = alertDataOperation.getAlertListByDeviceId(deviceModel.getId());
        List<DB_AreaModel> db_areaModels = areaDataOperation.getAllArea();

        deviceModel.setId(db_deviceModel.getId());
        deviceModel.setAlertCount(alerts.size());
        deviceModel.setDevice_id(db_deviceModel.getDeviceid());
        deviceModel.setAreaName(getDeviceArea(db_deviceModel, db_areaModels));
        deviceModel.setBlockName(getDeviceBlock(db_deviceModel, db_areaModels));
        deviceModel.setState(DeviceState.fromString(db_deviceModel.getState()));
        deviceModel.setMeasureName(getDeviceMeasureName(db_deviceModel, db_areaModels));
        deviceModel.setCoordinate(new Coordinate(db_deviceModel.getLatitude(), db_deviceModel.getLongitude()));
        DeviceTypeModel dtModel = new DeviceTypeModel(db_deviceModel.getDevicetype().getId(), db_deviceModel.getDevicetype().getName(), db_deviceModel.getDevicetype().getName());
        deviceModel.setDeviceType(dtModel);
        deviceModel.setComments(db_deviceModel.getComments());

        return deviceModel;
    }

    public AlertModel convertDBAlertModel2PortalAlertModel(DB_AlertModel db_alert, List<DB_AreaModel> dbAreas) {
        if (db_alert != null) {
            AlertModel alert = new AlertModel();
            for (DB_AreaModel db_areaModel : dbAreas) {
                if (db_areaModel.getId() == db_alert.getDevice().getArea_id()) {
                    db_alert.getDevice().setArea(db_areaModel);
                    break;
                }
            }
            alert.setComments(db_alert.getComments());
            alert.setCreatetime(db_alert.getCreatetime());
            alert.setTitle(db_alert.getTitle());
            //alert.setDevice(convertDBDeviceModel2PortalDeviceModel(db_alert.getDevice()));
            alert.setDevicename(db_alert.getDevice().getDeviceid());
            alert.setEndtime(db_alert.getEndtime());
            alert.setId(db_alert.getId());
            alert.setLevel(AlertLevel.values()[db_alert.getLevel()]);
            alert.setAreaName(getDeviceArea(db_alert.getDevice(), dbAreas));
            alert.setBlockName(getDeviceBlock(db_alert.getDevice(), dbAreas));
            alert.setMeasureName(getDeviceMeasureName(db_alert.getDevice(), dbAreas));
            return alert;
        } else {
            return null;
        }
    }

    public DeviceLogModel convertDBDeviceLog2PortalDeviceLog(DB_DeviceLogModel db_deviceLogModel) {
        DeviceLogModel deviceLogModel = new DeviceLogModel();
        deviceLogModel.setId(db_deviceLogModel.getId());
        deviceLogModel.setComments(db_deviceLogModel.getComments());
        deviceLogModel.setDeviceId(db_deviceLogModel.getId());
        deviceLogModel.setLogTime(db_deviceLogModel.getLogtime());
        deviceLogModel.setLogTitle(db_deviceLogModel.getLogtitle());
        return deviceLogModel;
    }

    public DataModel convertDBData2PortalData(DB_DataModel dbDataModel, List<DB_AreaModel> dbAreaModelList) {
        DataModel dataModel = new DataModel();
        for (DB_AreaModel dbAreaModel : dbAreaModelList) {
            if (dbAreaModel.getId() == dbDataModel.getDevice().getArea_id()) {
                dbDataModel.getDevice().setArea(dbAreaModel);
                break;
            }
        }
        dataModel.setId(dbDataModel.getId());
        dataModel.setAreaName(getDeviceArea(dbDataModel.getDevice(), dbAreaModelList));
        dataModel.setBlockName(getDeviceBlock(dbDataModel.getDevice(),dbAreaModelList));
        dataModel.setMeasureName(getDeviceMeasureName(dbDataModel.getDevice(),dbAreaModelList));
        dataModel.setDatatime(dbDataModel.getDatetime());
        dataModel.setDevice_id(dbDataModel.getDevice().getDeviceid());
        dataModel.setDatatype(dbDataModel.getDatatype().getDatatype());
        dataModel.setDatavalue(dbDataModel.getDatavalue());
        dataModel.setUnit(dbDataModel.getDatatype().getUnit());

        return dataModel;
    }

    //region PrivateMethods
    private String getDeviceArea(DB_DeviceModel deviceModel, List<DB_AreaModel> db_areaModels) {
        DB_AreaModel areaModel = deviceModel.getArea();
        while (areaModel.getParentarea_id() != 0) {
            for (DB_AreaModel db_areaModel : db_areaModels) {
                if (db_areaModel.getId() == areaModel.getParentarea_id()) {
                    areaModel = db_areaModel;
                }
            }
        }
        return areaModel.getName();
    }

    private String getDeviceBlock(DB_DeviceModel deviceModel, List<DB_AreaModel> db_areaModels) {
        DB_AreaModel areaModel = deviceModel.getArea();
        if (areaModel.getParentarea_id() == 0) {
            return null;
        }
        for (DB_AreaModel db_areaModel : db_areaModels) {
            if (db_areaModel.getId() == areaModel.getParentarea_id()) {
                if (db_areaModel.getParentarea_id() == 0) {
                    break;
                } else {
                    areaModel = db_areaModel;
                }
            }
        }
        return areaModel.getName();
    }

    private String getDeviceMeasureName(DB_DeviceModel deviceModel, List<DB_AreaModel> db_areaModels) {
        DB_AreaModel areaModel = deviceModel.getArea();
        if (areaModel.getParentarea_id() == 0) {
            return null;
        }
        for (DB_AreaModel db_areaModel : db_areaModels) {
            if (db_areaModel.getId() == areaModel.getParentarea_id()) {
                areaModel = db_areaModel;
            }
        }
        if (areaModel.getParentarea_id() == 0) {
            return null;
        } else {
            return deviceModel.getArea().getName();
        }
    }
    //endregion
}
