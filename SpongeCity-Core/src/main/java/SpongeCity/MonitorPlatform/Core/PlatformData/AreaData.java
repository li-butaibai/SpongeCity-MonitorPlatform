package SpongeCity.MonitorPlatform.Core.PlatformData;

import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabermai on 2016/1/4.
 */
public class AreaData {
    public List<DB_AreaModel> getAllArea() {
        List<DB_AreaModel> areaList = new ArrayList<DB_AreaModel>();

        return areaList;
    }

    public DB_AreaModel getAreaInfo(int areaId) {
        DB_AreaModel area = new DB_AreaModel();

        return area;
    }
}
