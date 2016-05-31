package SpongeCity.MonitorPlatform.ScheduleTask.models;

import java.util.Date;

/**
 * Created by saber on 2016/5/31.
 */
public class DB_DeviceDataModel {
    private Date datetime;
    private int device_id;
    private int datatype_id;
    private float datavalue;

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public int getDevice_id() {
        return device_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
    }

    public int getDatatype_id() {
        return datatype_id;
    }

    public void setDatatype_id(int datatype_id) {
        this.datatype_id = datatype_id;
    }

    public float getDatavalue() {
        return datavalue;
    }

    public void setDatavalue(float datavalue) {
        this.datavalue = datavalue;
    }
}
