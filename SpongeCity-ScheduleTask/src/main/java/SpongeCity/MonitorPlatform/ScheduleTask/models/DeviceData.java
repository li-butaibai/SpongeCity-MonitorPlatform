package SpongeCity.MonitorPlatform.ScheduleTask.models;

import java.util.Date;

/**
 * Created by saber on 2016/5/31.
 */
public class DeviceData {
    private String deviceCode;
    private int deviceId;
    private int devicetypeId;
    private int attributeIndex;
    private float attributeData;
    private Date createtime;

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public int getAttributeIndex() {
        return attributeIndex;
    }

    public void setAttributeIndex(int attributeIndex) {
        this.attributeIndex = attributeIndex;
    }

    public float getAttributeData() {
        return attributeData;
    }

    public void setAttributeData(float attributeData) {
        this.attributeData = attributeData;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getDevicetypeId() {
        return devicetypeId;
    }

    public void setDevicetypeId(int devicetypeId) {
        this.devicetypeId = devicetypeId;
    }
}
