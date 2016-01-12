package controllers;

import SpongeCity.MonitorPlatform.Core.PlatformData.AreaDataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DataOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataModel;
import Util.DeviceDataFileWriter;
import Util.ModelConverter;
import models.DataModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
        String filePath = "";
        DeviceDataFileWriter writer = new DeviceDataFileWriter();
        DataOperation dataOperation = new DataOperation();
        List<DataModel> dataModelList = new ArrayList<DataModel>();
        ModelConverter converter = new ModelConverter();
        List<DB_DataModel> dbDataModelList = dataOperation.getData(dataTypeid, areaId);

        if (dbDataModelList != null) {
            AreaDataOperation areaDataOperation = new AreaDataOperation();
            List<DB_AreaModel> dbAreaModelList = areaDataOperation.getAllArea();
            for (DB_DataModel dbDataModel : dbDataModelList) {
                dataModelList.add(converter.convertDBData2PortalData(dbDataModel, dbAreaModelList));
            }
            String[] heads = new String[]{"时间","区域","地块","单项措施","设备","数据类型","值","单位"};
            writer.writeCSV(heads,dataModelList,"","");
        }

        return filePath;
    }

    public String getDataCSVFilePath(int dataTypeid, int areaId, Date startTime, Date endTime) {
        String filePath = "";
        DataOperation dataOperation = new DataOperation();
        List<DataModel> dataModelList = new ArrayList<DataModel>();
        ModelConverter converter = new ModelConverter();
        List<DB_DataModel> dbDataModelList = dataOperation.getData(dataTypeid, areaId, startTime, endTime);

        if (dbDataModelList != null) {
            AreaDataOperation areaDataOperation = new AreaDataOperation();
            List<DB_AreaModel> dbAreaModelList = areaDataOperation.getAllArea();
            for (DB_DataModel dbDataModel : dbDataModelList) {
                dataModelList.add(converter.convertDBData2PortalData(dbDataModel, dbAreaModelList));
            }
        }
        return filePath;
    }
}
