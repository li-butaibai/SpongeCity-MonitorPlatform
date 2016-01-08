package SpongeCity.MonitorPlatform.DBAccess.Model;

/**
 * Created by sabermai on 2016/1/8.
 */
public class DB_DataTypeModel {
    private int id;
    private String datatype;
    private String unit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
