package SpongeCity.MonitorPlatform.DBAccess.Model;

/**
 * Created by sabermai on 2016/1/4.
 */
public class DB_AreaModel {
    private int id;
    private String name;
    private float size;
    private String position;
    private int parentarea_id;

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

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getParentarea_id() {
        return parentarea_id;
    }

    public void setParentarea_id(int parentarea_id) {
        this.parentarea_id = parentarea_id;
    }
}
