package models;

import java.util.Date;
import java.util.List;

/**
 * Created by saber on 2016/5/25.
 */
public class DeviceDataModel {
    private int deviceId;
    private String deviceCode;
    private String deviceTypeName;
    private String modelName;
    private int dataTypeId;
    private String dataTypeName;
    private String unit;
    private List<Float> datas;
    private List<Date> dates;

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

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public List<Float> getDatas() {
        return datas;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(int dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    public String getDataTypeName() {
        return dataTypeName;
    }

    public void setDataTypeName(String dataTypeName) {
        this.dataTypeName = dataTypeName;
    }

    public void setDatas(List<Float> datas) {
        this.datas = datas;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
