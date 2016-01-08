package SpongeCity.MonitorPlatform.Core.PlatformData;

import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DataDA;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sabermai on 2016/1/8.
 */
public class DataOperation {
    private DataDA dataDA = new DataDA();

    public List<DB_DataModel> getData(int dataTypeid, int areaId) {
        List<DB_DataModel> datas = new ArrayList<DB_DataModel>();
        try {
            datas = dataDA.getDataByDataypeandArea(dataTypeid, areaId);
        } catch (Exception ex) {
            //log
        }
        return datas;
    }

    public List<DB_DataModel> getData(int dataTypeid, int areaId, Date startTime, Date endTime) {
        List<DB_DataModel> datas = new ArrayList<DB_DataModel>();
        try {
            datas = dataDA.getDataByDataTypeAreaAndTime(dataTypeid, areaId, startTime, endTime);
        } catch (Exception ex) {
            //log
        }
        return datas;
    }
}
