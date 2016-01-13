package SpongeCity.MonitorPlatform.Core.PlatformData;

import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AreaDA;
import SpongeCity.MonitorPlatform.DBAccess.DataAccess.DataDA;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DataTypeModel;

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
            List<DB_AreaModel> areas = getAllChildrenArea(areaId);
            datas = dataDA.getDataByDataypeandArea(dataTypeid, areas);
        } catch (Exception ex) {
            //log
        }
        return datas;
    }

    public List<DB_DataModel> getData(int dataTypeid, int areaId, Date startTime, Date endTime) {
        List<DB_DataModel> datas = new ArrayList<DB_DataModel>();
        try {
            List<DB_AreaModel> areas = getAllChildrenArea(areaId);
            datas = dataDA.getDataByDataTypeAreaAndTime(dataTypeid, areas, startTime, endTime);
        } catch (Exception ex) {
            //log
        }
        return datas;
    }

    public List<DB_DataModel> getDataByAreaId(int areaId) {
        List<DB_DataModel> datas = new ArrayList<DB_DataModel>();
        try {
            List<DB_AreaModel> areas = getAllChildrenArea(areaId);
            datas = dataDA.getDataByArea(areas);
        } catch (Exception ex) {
            //log
        }
        return datas;
    }

    public List<DB_DataTypeModel> getDataTypeList() {
        List<DB_DataTypeModel> datatypes = new ArrayList<DB_DataTypeModel>();
        try {
            datatypes = dataDA.getDataTypeList();
        } catch (Exception ex) {
            //log
        }
        return datatypes;
    }

    private List<DB_AreaModel> getAllChildrenArea(int areaId) {
        List<DB_AreaModel> areas = new ArrayList<DB_AreaModel>();
        AreaDA areaData = new AreaDA();
        areas = areaData.getAreaAllChildren(areaId);
        areas.add(areaData.getAreaById(areaId));
        return areas;
    }
}
