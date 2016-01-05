package SpongeCity.MonitorPlatform.DBAccess.Model;

import java.util.Date;

/**
 * Created by sabermai on 2016/1/4.
 */
public class DB_AlertModel {
    private int id;
    private String title;
    private DB_DeviceModel device;
    private String comments;
    private Date createtime;
    private Date endtime;
    private String state;
    private int level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DB_DeviceModel getDevice() {
        return device;
    }

    public void setDevice(DB_DeviceModel device) {
        this.device = device;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
