/**
 * Created by etadmin on 5/31/2016.
 */
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import SpongeCity.MonitorPlatform.ScheduleTask.ScheduleTask;

public class SpongeCityDataSyncLoader extends HttpServlet {

    @Override
    public void init() throws ServletException {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        try {
            ScheduleTask  task = new ScheduleTask();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
