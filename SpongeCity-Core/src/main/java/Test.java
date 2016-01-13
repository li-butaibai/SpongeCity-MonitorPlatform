import SpongeCity.MonitorPlatform.Core.PlatformData.AlertDataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DataOperation;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sabermai on 2016/1/8.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        DataOperation dataOperation = new DataOperation();
        dataOperation.getDataTypeList();
    }
}
