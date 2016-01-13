import SpongeCity.MonitorPlatform.Core.PlatformData.AreaDataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DataOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataModel;
import Util.DeviceDataFileWriter;
import Util.ModelConverter;
import controllers.DataController;
import models.DataModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sabermai on 2016/1/12.
 */
public class Test {
    public static void main(String[] args) {
        DeviceDataFileWriter writer = new DeviceDataFileWriter();
        DataOperation dataOperation = new DataOperation();
        List<DataModel> dataModelList = new ArrayList<DataModel>();
        ModelConverter converter = new ModelConverter();
        List<DB_DataModel> dbDataModelList = dataOperation.getData(1, 1, new Date(116, 0, 5), new Date(116, 0, 9));

        if (dbDataModelList != null) {
            AreaDataOperation areaDataOperation = new AreaDataOperation();
            DB_AreaModel areaModel = areaDataOperation.getAreaInfo(1);
            List<DB_AreaModel> dbAreaModelList = areaDataOperation.getAllArea();
            for (DB_DataModel dbDataModel : dbDataModelList) {
                dataModelList.add(converter.convertDBData2PortalData(dbDataModel, dbAreaModelList));
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            String filePath = DataController.class.getClassLoader().getResource("").getPath().replace("classes", "MonitorPortal") + "DeviceDataCSVFiles/";
            String fileName = areaModel.getName() + "_" + dataModelList.get(0).getDatatype() + "_" + df.format(new Date()) + ".csv";
            String[] heads = new String[]{"时间", "区域", "地块", "单项措施", "设备", "数据类型", "值", "单位"};
            writer.writeCSV(heads, dataModelList, filePath, fileName);
        }
    }
}
