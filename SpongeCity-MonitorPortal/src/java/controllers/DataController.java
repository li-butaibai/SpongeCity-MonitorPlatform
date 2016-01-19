package controllers;

import SpongeCity.MonitorPlatform.Core.PlatformData.AreaDataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DeviceDataOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataTypeModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceModel;
import Util.DeviceDataFileWriter;
import Util.ModelConverter;
import models.DataInfoModel;
import models.DataModel;
import models.DataType;
import models.DataTypeModel;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by EriclLee on 15/12/29.
 */
@Controller
@RequestMapping(value = "/data")
public class DataController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return null;
    }

    @RequestMapping(value = "/datadownload", method = RequestMethod.GET)
    public ModelAndView datadownload(int areaId) {
        ModelAndView modelAndView = new ModelAndView("/data/download");
        List<DataInfoModel> dataInfoModels = getDataInfo(areaId);
        modelAndView.addObject("data", dataInfoModels);
        return modelAndView;
    }

    @RequestMapping(value = "/exportdata", method = RequestMethod.GET)
    @ResponseBody
    public String getDataCSVFilePath(int dataTypeId, int areaId) {
        try {
            DataOperation dataOperation = new DataOperation();
            List<DB_DataModel> dbDataModelList = dataOperation.getData(dataTypeId, areaId);
            String filename = createDataCSVFile(dbDataModelList, areaId);
            return filename;
        } catch (Exception ex) {
            return "";
        }
    }

    public String getDataCSVFilePath(int dataTypeId, int areaId, Date startTime, Date endTime) {
        try {
            DataOperation dataOperation = new DataOperation();
            List<DB_DataModel> dbDataModelList = dataOperation.getData(dataTypeId, areaId, startTime, endTime);
            return createDataCSVFile(dbDataModelList, areaId);
        } catch (Exception ex) {
            return "";
        }
    }

    public List<DataTypeModel> getDataTypeList() {
        try {
            List<DataTypeModel> dataTypes = new ArrayList<DataTypeModel>();
            DataOperation dataOperation = new DataOperation();
            ModelConverter converter = new ModelConverter();
            List<DB_DataTypeModel> dbDataTypeModels = dataOperation.getDataTypeList();
            for (DB_DataTypeModel dbDataTypeModel : dbDataTypeModels) {
                dataTypes.add(converter.convertDBDatatype2PortalDatatype(dbDataTypeModel));
            }
            return dataTypes;
        } catch (Exception ex) {
            return null;
        }
    }

    //return device data
    public String getDeviceData(int dataTypeId, int deviceId, Date startTime, Date endTime) {
        try {
            DataOperation dataOperation = new DataOperation();
            List<DB_DataModel> dbDataModelList = dataOperation.getDataByDataTypeAndDeviceId(dataTypeId, deviceId, startTime, endTime);
            List<String> dateList = new ArrayList<String>();
            List<Float> valueList = new ArrayList<Float>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            for (DB_DataModel dbDataModel : dbDataModelList) {
                dateList.add(sdf.format(dbDataModel.getDatetime()));
                valueList.add(dbDataModel.getDatavalue());
            }
            return "";
        } catch (Exception ex) {
            return "";
        }
    }

    //get dataType,deviceCount,dataItemCount
    public List<DataInfoModel> getDataInfo(int areaId) {
        List<DataInfoModel> dataInfoModels = new ArrayList<DataInfoModel>();
        DataOperation dataOperation = new DataOperation();
        Map<String, Integer> dataTypes = new HashMap<String, Integer>();
        Map<String, Integer> dataItemCount = new HashMap<String, Integer>();
        Map<String, Set<Integer>> deviceInfo = new HashMap<String, Set<Integer>>();
        List<DB_DataModel> dbDataModels = dataOperation.getDataByAreaId(areaId);
        for (DB_DataModel dbDataModel : dbDataModels) {
            String key = dbDataModel.getDatatype().getDatatype();
            dataTypes.put(key, dbDataModel.getDatatype().getId());
            boolean keyExist = dataItemCount.containsKey(key);
            if (keyExist) {
                dataItemCount.put(key, dataItemCount.get(key) + 1);
                Set<Integer> set = deviceInfo.get(key);
                set.add(dbDataModel.getDevice().getId());
                deviceInfo.put(key, set);
            } else {
                dataItemCount.put(key, 1);
                Set<Integer> deviceSet = new HashSet<Integer>();
                deviceSet.add(dbDataModel.getDevice().getId());
                deviceInfo.put(key, deviceSet);
            }
        }
        for (String dataType : dataItemCount.keySet()) {
            DataInfoModel dataInfoModel = new DataInfoModel();
            dataInfoModel.setDataTypeId(dataTypes.get(dataType));
            dataInfoModel.setAreaId(areaId);
            dataInfoModel.setDataType(dataType);
            dataInfoModel.setDataItemCount(dataItemCount.get(dataType));
            dataInfoModel.setDeviceCount(deviceInfo.get(dataType).size());
            dataInfoModels.add(dataInfoModel);
        }
        return dataInfoModels;
    }

    private String createDataCSVFile(List<DB_DataModel> dbDataModelList, int areaId) {
        DeviceDataFileWriter writer = new DeviceDataFileWriter();
        DataOperation dataOperation = new DataOperation();
        List<DataModel> dataModelList = new ArrayList<DataModel>();
        ModelConverter converter = new ModelConverter();

        if (dbDataModelList != null && dbDataModelList.size() > 0) {
            AreaDataOperation areaDataOperation = new AreaDataOperation();
            DB_AreaModel areaModel = areaDataOperation.getAreaInfo(areaId);
            List<DB_AreaModel> dbAreaModelList = areaDataOperation.getAllArea();
            for (DB_DataModel dbDataModel : dbDataModelList) {
                dataModelList.add(converter.convertDBData2PortalData(dbDataModel, dbAreaModelList));
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            String filePath = this.getClass().getClassLoader().getResource("").getPath().replace("classes", "DeviceDataCSVFiles").replace("WEB-INF/", "");
            String fileName = areaModel.getName() + "_" + dataModelList.get(0).getDatatype() + "_" + df.format(new Date()) + ".csv";
            String[] heads = new String[]{"时间", "区域", "地块", "单项措施", "设备", "数据类型", "值", "单位"};
            writer.writeCSV(heads, dataModelList, filePath, fileName);
            return "DeviceDataCSVFiles/" + fileName;
        } else {
            return "";
        }
    }

    private Set<Integer> getAreaDevices(int areaId) {
        DeviceDataOperation deviceDataOperation = new DeviceDataOperation();
        List<DB_DeviceModel> dbDeviceModels = deviceDataOperation.getDeviceListByAreaId(areaId);
        Set<Integer> setDevicesByArea = new HashSet<Integer>();
        for (DB_DeviceModel dbDeviceModel : dbDeviceModels) {
            setDevicesByArea.add(dbDeviceModel.getId());
        }
        return setDevicesByArea;
    }
}
