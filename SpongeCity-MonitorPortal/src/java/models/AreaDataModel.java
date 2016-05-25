package models;

import java.util.List;

/**
 * Created by saber on 2016/5/25.
 */
public class AreaDataModel {
    private int areaId;
    private String areaName;
    private int dataTypeId;
    private String dataTypeName;
    private String unit;
    private List<DeviceDataModel> dataList;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<DeviceDataModel> getDataList() {
        return dataList;
    }

    public void setDataList(List<DeviceDataModel> dataList) {
        this.dataList = dataList;
    }
}
