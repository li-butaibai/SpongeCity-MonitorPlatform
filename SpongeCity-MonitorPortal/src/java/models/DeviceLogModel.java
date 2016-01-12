package models;

import java.util.Date;

/**
 * Created by sabermai on 2016/1/12.
 */
public class DeviceLogModel {
    private int id;
    private Date logTime;
    private int deviceId;
    private String comments;
    private String logTitle;

    public String getLogTitle() {
        return logTitle;
    }

    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
