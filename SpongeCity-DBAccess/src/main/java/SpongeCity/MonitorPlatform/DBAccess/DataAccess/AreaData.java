package SpongeCity.MonitorPlatform.DBAccess.DataAccess;

import SpongeCity.MonitorPlatform.DBAccess.Common.SqlConnection;
import SpongeCity.MonitorPlatform.DBAccess.Interface.IAreaOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AlertModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public class AreaData {
    private static SqlSession session = SqlConnection.getSession().openSession();

    public List<DB_AreaModel> getAllArea() {
        try {
            IAreaOperation areaOperation = session.getMapper(IAreaOperation.class);
            List<DB_AreaModel> areas = areaOperation.getAllArea();
            return areas;
        } finally {
            session.close();
        }
    }

    public DB_AreaModel getAreaById(int areaId) {
        try {
            IAreaOperation areaOperation = session.getMapper(IAreaOperation.class);
            DB_AreaModel area = areaOperation.getAreaById(areaId);
            return area;
        } finally {
            session.close();
        }
    }

    public List<DB_AreaModel> getAreaAllChildren(int areaId) {
        try {
            IAreaOperation areaOperation = session.getMapper(IAreaOperation.class);
            List<DB_AreaModel> areas = new ArrayList<DB_AreaModel>();
            List<DB_AreaModel> areaList = getAllArea();
            areas = getChildren(areaList, areaId);
            return areas;
        } finally {
            session.close();
        }
    }

    private List<DB_AreaModel> getChildren(List<DB_AreaModel> areaList, int areaId) {
        IAreaOperation areaOperation = session.getMapper(IAreaOperation.class);
        List<DB_AreaModel> areas = new ArrayList<DB_AreaModel>();
        List<DB_AreaModel> result = new ArrayList<DB_AreaModel>();
        areas = getAreaDirectChildren(areaList, areaId);
        if (areas != null && areas.size() != 0) {
            for (DB_AreaModel area : areas) {
                result.add(area);
                result.addAll(getChildren(areaList, area.getId()));
            }
        }
        return result;
    }

    private List<DB_AreaModel> getAreaDirectChildren(List<DB_AreaModel> areaList, int areaId) {
        List<DB_AreaModel> areas = new ArrayList<DB_AreaModel>();
        for (DB_AreaModel item : areaList) {
            if (item.getParentarea_id() == areaId) {
                areas.add(item);
            }
        }
        return areas;
    }
}
