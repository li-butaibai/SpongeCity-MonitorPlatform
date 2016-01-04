package SpongeCity.MonitorPlatform.DBAccess.DataAccess;

import SpongeCity.MonitorPlatform.DBAccess.Common.SqlConnection;
import SpongeCity.MonitorPlatform.DBAccess.Interface.IAreaOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import org.apache.ibatis.session.SqlSession;

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

    public DB_AreaModel getAreaById(int areaId){
        try {
            IAreaOperation areaOperation = session.getMapper(IAreaOperation.class);
            DB_AreaModel area = areaOperation.getAreaById(areaId);
            return area;
        } finally {
            session.close();
        }
    }
}
