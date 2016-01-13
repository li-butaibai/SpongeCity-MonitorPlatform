package controllers;

import SpongeCity.MonitorPlatform.Core.PlatformData.AreaDataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DataOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataTypeModel;
import Util.DeviceDataFileWriter;
import Util.ModelConverter;
import models.DataModel;
import models.DataType;
import models.DataTypeModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public ModelAndView datadownload() {
        return null;
    }

    public String getDataCSVFilePath(int dataTypeid, int areaId) {
        try {
            DataOperation dataOperation = new DataOperation();
            List<DB_DataModel> dbDataModelList = dataOperation.getData(dataTypeid, areaId);
            return createDataCSVFile(dbDataModelList, areaId);
        } catch (Exception ex) {
            return "";
        }
    }

    public String getDataCSVFilePath(int dataTypeid, int areaId, Date startTime, Date endTime) {
        try {
            DataOperation dataOperation = new DataOperation();
            List<DB_DataModel> dbDataModelList = dataOperation.getData(dataTypeid, areaId, startTime, endTime);
            return createDataCSVFile(dbDataModelList, areaId);
        } catch (Exception ex) {
            return "";
        }
    }

    public List<DataTypeModel> getDataTypeList(){
        try {
            List<DataTypeModel> dataTypes = new ArrayList<DataTypeModel>();
            DataOperation dataOperation = new DataOperation();
            ModelConverter converter = new ModelConverter();
            List<DB_DataTypeModel> dbDataTypeModels = dataOperation.getDataTypeList();
            for(DB_DataTypeModel dbDataTypeModel : dbDataTypeModels){
                dataTypes.add(converter.convertDBDatatype2PortalDatatype(dbDataTypeModel));
            }
            return dataTypes;
        }catch (Exception ex){
            return null;
        }
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
            String filePath = this.getClass().getClassLoader().getResource("").getPath().replace("classes", "MonitorPortal") + "DeviceDataCSVFiles/";
            String fileName = areaModel.getName() + "_" + dataModelList.get(0).getDatatype() + "_" + df.format(new Date()) + ".csv";
            String[] heads = new String[]{"时间", "区域", "地块", "单项措施", "设备", "数据类型", "值", "单位"};
            writer.writeCSV(heads, dataModelList, filePath, fileName);
            return "DeviceDataCSVFiles/" + fileName;
        } else {
            return "";
        }
    }
}
