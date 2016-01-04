package SpongeCity.MonitorPlatform.DBAccess.Model;

/**
 * Created by sabermai on 2016/1/4.
 */
public class DB_DeviceTypeModel {
    private int id;
    private String name;
    private String comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
