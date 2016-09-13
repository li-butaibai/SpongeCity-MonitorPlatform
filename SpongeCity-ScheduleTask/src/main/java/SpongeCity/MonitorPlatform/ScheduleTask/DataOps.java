package SpongeCity.MonitorPlatform.ScheduleTask;

import SpongeCity.MonitorPlatform.Core.PlatformData.DataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DeviceDataOperation;
import SpongeCity.MonitorPlatform.DBAccess.Common.SqlConnection;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataTypeModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceTypeModel;
import SpongeCity.MonitorPlatform.ScheduleTask.models.DB_DeviceDataModel;
import SpongeCity.MonitorPlatform.ScheduleTask.models.DeviceData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by saber on 2016/5/30.
 */
public class DataOps {
    private final String apiAddress = "http://hm-iot.chinacloudapp.cn:80/api";
    private DeviceDataOperation deviceDataOperation = new DeviceDataOperation();
    private List<DB_DeviceModel> devices = new ArrayList<DB_DeviceModel>();

    public void extractDeviceDatas(String startTime, String endTime) {
        devices = deviceDataOperation.getAllDevice();
        if (devices.size() > 0) {
            List<DeviceData> datas = new ArrayList<DeviceData>();
            /*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");*/

            for (DB_DeviceModel device : devices) {
                //Random r = new Random();
                String address = apiAddress + String.format("/devices/%s/events?startDate=%s&endDate=%s", device.getDeviceid(), startTime, endTime);
                //JSONObject jsonObj = RestApiHelper.get(address);
                RestApiHelper helper = new RestApiHelper();
                JSONObject jsonObj = helper.get(address);
                if (jsonObj != null) {
                    JSONArray jsonArray = JSONArray.fromObject(((JSONObject) jsonObj.get("result")).get("results"));
                    if (jsonArray != null && jsonArray.size() > 0) {
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject item = jsonArray.getJSONObject(i);
                            DeviceData dd = new DeviceData();
                            dd.setDeviceCode(item.get("id").toString());
                            dd.setDeviceId(device.getId());
                            dd.setDevicetypeId(device.getDevicetype().getId());
                            dd.setAttributeData(Float.parseFloat(item.get("attributeData").toString()));
                            dd.setAttributeIndex(Integer.parseInt(item.get("attributeIndex").toString()));
                            Long timestamp = Long.parseLong(item.get("deviceTimestamp").toString());
                            dd.setCreatetime(new Date(timestamp + 8 * 60 * 60 * 1000));
                            //dd.setCreatetime(new Date(timestamp));
                            datas.add(dd);
                        }
                    }
                }
            }
            if (datas.size() > 0) {
                SaveData(datas);
            }
        }
    }

    private void SaveData(List<DeviceData> datas) {
        try {
            List<DB_DeviceDataModel> dbDatas = new ArrayList<DB_DeviceDataModel>();
            for (DeviceData data : datas) {
                DB_DeviceDataModel dbModel = new DB_DeviceDataModel();
                dbModel.setDatatype_id(getDataType(data.getDevicetypeId(), data.getAttributeIndex()).getId());
                dbModel.setDatavalue(data.getAttributeData());
                dbModel.setDevice_id(data.getDeviceId());
                dbModel.setDatetime(data.getCreatetime());
                dbDatas.add(dbModel);
            }
            String strCmd = "insert into data (datatime,device_id,datatype_id,datavalue) values ";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            for (DB_DeviceDataModel dbData : dbDatas) {
                strCmd += String.format("('%s',%d,%d,%f),", sdf.format(dbData.getDatetime()), dbData.getDevice_id(), dbData.getDatatype_id(), dbData.getDatavalue());
            }
            int result = SqlConnection.saveImportData(strCmd.substring(0, strCmd.length() - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DB_DataTypeModel getDataType(int devicetypeId, int attributeIndex) {
        DB_DataTypeModel result = new DB_DataTypeModel();
        List<DB_DataTypeModel> datatypes = new ArrayList<DB_DataTypeModel>();
        DataOperation dataOperation = new DataOperation();
        datatypes = dataOperation.getDataTypeListByDeviceTypeId(devicetypeId);
        for (DB_DataTypeModel datatype : datatypes) {
            if (datatype.getAttributeIndex() == attributeIndex) {
                result = datatype;
                break;
            }
        }
        return result;
    }
}
