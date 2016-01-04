package models;

/**
 * Created by EriclLee on 15/12/30.
 */
public class DeviceTypeModel {
    private int id;
    private String displayName;
    private String name;

    public DeviceTypeModel(int id, String displayName, String name) {
        this.id = id;
        this.displayName = displayName;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return name;
    }
}
