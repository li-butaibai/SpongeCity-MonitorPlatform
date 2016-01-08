package SpongeCity.MonitorPlatform.DBAccess.Model;

import java.util.Date;

/**
 * Created by sabermai on 2016/1/8.
 */
public class DB_DataModel {
    private int id;
    private Date datetime;
    private DB_DeviceModel device;
    private DB_DataTypeModel datatype;
    private float datavalue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public DB_DeviceModel getDevice() {
        return device;
    }

    public void setDevice(DB_DeviceModel device) {
        this.device = device;
    }

    public DB_DataTypeModel getDatatype() {
        return datatype;
    }

    public void setDatatype(DB_DataTypeModel datatype) {
        this.datatype = datatype;
    }

    public float getDatavalue() {
        return datavalue;
    }

    public void setDatavalue(float datavalue) {
        this.datavalue = datavalue;
    }
}
