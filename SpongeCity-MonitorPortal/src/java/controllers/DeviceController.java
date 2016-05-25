package controllers;

import SpongeCity.MonitorPlatform.Core.PlatformData.*;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.LogDA;
import SpongeCity.MonitorPlatform.DBAccess.Model.*;
import Util.ModelConverter;
import Util.SortList;
import models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by EriclLee on 15/12/29.
 */
@Controller
@RequestMapping(value = "/devices")
public class DeviceController {
    private final int DEVICE_LOG_COUNT = 10;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(int pageIndex, int areaId, String sortKey, String sortDes) {
        ModelAndView modelAndView = new ModelAndView("/devices/index");
        PageDivisionModel<DeviceModel> deviceModelPageDivisionModel = new PageDivisionModel<DeviceModel>();
        List<DeviceModel> deviceModels = new ArrayList<DeviceModel>();
        //TODO: get device list;
        List<DeviceModel> allDevices = devices(areaId, null);
        deviceModelPageDivisionModel.setRecordCount(allDevices.size());
        deviceModelPageDivisionModel.setCurrentPageIndex(pageIndex);
        if (sortKey == null || sortKey == "") {
            sortKey = "getDeviceTypeName";
        }
        if (sortDes == null || sortDes == "") {
            sortDes = "desc";
        }
        SortList<DeviceModel> sortList = new SortList<DeviceModel>();
        sortList.Sort(allDevices, sortKey, sortDes);
        Integer pageSize = deviceModelPageDivisionModel.getPageSize();
        Integer toIndex = pageIndex * pageSize + pageSize;
        if (allDevices.size() - pageIndex * pageSize < pageSize) {
            toIndex = allDevices.size();
        }
        deviceModels = allDevices.subList(pageIndex * pageSize, toIndex);
        deviceModelPageDivisionModel.setData(deviceModels);
        modelAndView.addObject("devices", deviceModelPageDivisionModel);
        modelAndView.addObject("sortKey", sortKey);
        modelAndView.addObject("sortDes", sortDes);
        return modelAndView;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView detail(int deviceId) {
        ModelAndView modelAndView = new ModelAndView("/devices/detail");
        DeviceModel deviceModel = new DeviceModel();
        ModelConverter converter = new ModelConverter();

        //get device info
        DeviceDataOperation deviceDataOperation = new DeviceDataOperation();
        DB_DeviceModel db_deviceModel = deviceDataOperation.getDeviceInfo(deviceId);
        deviceModel = converter.convertDBDeviceModel2PortalDeviceModel(db_deviceModel);

        //get device data
        DataOperation dataOperation = new DataOperation();
        List<DB_DataModel> db_dataModels = dataOperation.getData(deviceId);
        List<DataModel> dataModels = new ArrayList<DataModel>();
        if(db_dataModels!=null)
        {
            for(DB_DataModel dm : db_dataModels)
            {
                DataModel dataModel = new DataModel();
                dataModel.setId(dm.getId());
                dataModel.setDatatime(dm.getDatetime());
                dataModel.setDatatype(dm.getDatatype().getDatatype());
                dataModel.setDatavalue(dm.getDatavalue());
                dataModel.setUnit(dm.getDatatype().getUnit());
                dataModels.add(dataModel);
            }
        }

        //get device log
        LogDataOperation logDataOperation = new LogDataOperation();
        List<DB_DeviceLogModel> db_deviceLogModels = logDataOperation.getLastDeviceLogList(deviceId, DEVICE_LOG_COUNT);
        List<DeviceLogModel> deviceLogModels = new ArrayList<DeviceLogModel>();
        if (db_deviceLogModels != null) {
            for (DB_DeviceLogModel db_deviceLogModel : db_deviceLogModels) {
                deviceLogModels.add(converter.convertDBDeviceLog2PortalDeviceLog(db_deviceLogModel));
            }
        }
        deviceModel.setDeviceLogList(deviceLogModels);
        deviceModel.setDataList(dataModels);
        modelAndView.addObject("device", deviceModel);
        return modelAndView;
    }

    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    @ResponseBody
    public List<DeviceModel> devices(@RequestParam int areaId, int[] deviceTypeIds) {
        List<DeviceModel> deviceModels = new ArrayList<DeviceModel>();
        AreaDataOperation areaDataOperation = new AreaDataOperation();
        List<DB_AreaModel> db_areaModels = areaDataOperation.getAllArea();
        List<Integer> allAreaIds = getAllSubAreaId(areaId, db_areaModels);
        DeviceDataOperation deviceDataOperation = new DeviceDataOperation();
        List<DB_DeviceModel> deviceModelList = deviceDataOperation.getAllDevice();
        List<DB_DeviceModel> deviceModelListByTypes = getDevicesByGTypes(deviceModelList, deviceTypeIds);
        AlertDataOperation alertDataOperation = new AlertDataOperation();
        DataOperation dataOperation = new DataOperation();
        List<DB_DeviceTypeModel> deviceTypeModels = deviceDataOperation.getAllDeviceType();
        for (Integer aId : allAreaIds) {
            for (DB_DeviceModel db_deviceModel : deviceModelListByTypes) {
                if (db_deviceModel.getArea().getId() == aId) {

                    DeviceModel deviceModel = new DeviceModel();
                    ModelConverter converter = new ModelConverter();
                    deviceModel = converter.convertDBDeviceModel2PortalDeviceModel(db_deviceModel);
                    deviceModel.setDataList(new ArrayList<DataModel>());
                    List<DB_DataTypeModel> db_dataTypeModels = deviceDataOperation.getAllDeviceTypeByDeviceId(db_deviceModel.getId());
                    for(DB_DataTypeModel dt : db_dataTypeModels)
                    {
                        List<DB_DataModel> dataModels = dataOperation.getDataByDeviceAndDt(db_deviceModel.getId(), dt.getId());
                        for(DB_DataModel dm : dataModels)
                        {
                            DataModel dmodel = new DataModel();
                            dmodel.setId(dm.getId());
                            dmodel.setDatatime(dm.getDatetime());
                            dmodel.setDatatype(dm.getDatatype().getDatatype());
                            dmodel.setDatavalue(dm.getDatavalue());
                            dmodel.setUnit(dm.getDatatype().getUnit());
                            deviceModel.getDataList().add(dmodel);
                        }
                    }
                    deviceModels.add(deviceModel);
                }
            }
        }
        return deviceModels;
    }

    private List<Integer> getAllSubAreaId(int aid, List<DB_AreaModel> db_areaModelList) {
        List<Integer> allSubAreaId = new ArrayList<Integer>();
        allSubAreaId.add(aid);
        for (DB_AreaModel areaDbModel : db_areaModelList) {
            if (areaDbModel.getParentarea_id() == aid) {
                allSubAreaId.addAll(getAllSubAreaId(areaDbModel.getId(), db_areaModelList));
            }
            if(aid==16 && areaDbModel.getParentarea_id()==0 && areaDbModel.getId()!=16)
            {
                allSubAreaId.addAll(getAllSubAreaId(areaDbModel.getId(), db_areaModelList));
            }
        }
        return allSubAreaId;
    }

    private List<DB_DeviceModel> getDevicesByGTypes(List<DB_DeviceModel> deviceModels, int[] deviceTypeIds) {
        List<DB_DeviceModel> result = new ArrayList<DB_DeviceModel>();
        if (deviceTypeIds != null) {
            for (int typeId : deviceTypeIds) {
                for (DB_DeviceModel db_deviceModel : deviceModels) {
                    if (db_deviceModel.getDevicetype().getId() == typeId) {
                        result.add(db_deviceModel);
                    }
                }
            }
        } else {
            result = deviceModels;
        }
        return result;
    }

    //region Unused. Already extract to Util.ModelConverter class
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
