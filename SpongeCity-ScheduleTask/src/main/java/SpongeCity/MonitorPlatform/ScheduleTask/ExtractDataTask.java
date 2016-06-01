package SpongeCity.MonitorPlatform.ScheduleTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.TimerTask;

/**
 * Created by saber on 2016/5/30.
 */
public class ExtractDataTask extends TimerTask {
    private long period;

    public ExtractDataTask(long period) {
        this.period = period;
    }

    public void run() {
        try {
            DataOps ops = new DataOps();
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date startTime = sdf.parse(sdf.format(now.getTime() - period));
            Date endTime = sdf.parse(sdf.format(now));

            sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            TimeZone pst = TimeZone.getTimeZone("GMT");
            sdf.setTimeZone(pst);
            String str1 = sdf.format(startTime);
            String str2 = sdf.format(endTime);
            ops.extractDeviceDatas(str1, str2);
            /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ops.extractDeviceDatas(sdf.parse("2016-05-28"), sdf.parse("2016-05-30"));*/
        } catch (Exception ex) {

        }
    }
}
