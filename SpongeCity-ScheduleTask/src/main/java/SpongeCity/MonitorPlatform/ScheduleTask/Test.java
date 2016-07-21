package SpongeCity.MonitorPlatform.ScheduleTask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by saber on 2016/5/30.
 */
public class Test {
    public static void main(String[] args) {
        /*DataOps ops = new DataOps();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ops.extractDeviceDatas(sdf.parse("2016-05-28"),sdf.parse("2016-05-30"));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        new ScheduleTask();
    }
}
