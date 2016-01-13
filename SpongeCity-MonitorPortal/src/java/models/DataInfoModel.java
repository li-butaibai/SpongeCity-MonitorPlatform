package models;

/**
 * Created by sabermai on 2016/1/13.
 */
public class DataInfoModel {
    private String dataType;
    private int deviceCount;
    private int dataItemCount;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(int deviceCount) {
        this.deviceCount = deviceCount;
    }

    public int getDataItemCount() {
        return dataItemCount;
    }

    public void setDataItemCount(int dataItemCount) {
        this.dataItemCount = dataItemCount;
    }
}
