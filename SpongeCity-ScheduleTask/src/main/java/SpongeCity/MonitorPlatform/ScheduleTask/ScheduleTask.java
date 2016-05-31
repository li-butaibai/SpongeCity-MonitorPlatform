package SpongeCity.MonitorPlatform.ScheduleTask;

import java.util.Timer;

/**
 * Created by saber on 2016/5/30.
 */
public class ScheduleTask {
    private Timer timer;
    private final long period = 60 * 1000;

    public ScheduleTask() {
        this.timer = new Timer();
        timer.schedule(new ExtractDataTask(period), 0, period);
    }
}
