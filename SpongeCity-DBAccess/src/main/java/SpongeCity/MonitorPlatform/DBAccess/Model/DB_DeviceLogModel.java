package SpongeCity.MonitorPlatform.DBAccess.Model;

import java.util.Date;

/**
 * Created by sabermai on 2016/1/4.
 */
public class DB_DeviceLogModel {
    private int id;
    private Date logtime;
    private DB_DeviceModel device;
    private String logtitle;
    private String comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public DB_DeviceModel getDevice() {
        return device;
    }

    public void setDevice(DB_DeviceModel device) {
        this.device = device;
    }

    public String getLogtitle() {
        return logtitle;
    }

    public void setLogtitle(String logtitle) {
        this.logtitle = logtitle;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
