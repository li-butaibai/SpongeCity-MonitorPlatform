package models;

/**
 * Created by EriclLee on 15/12/30.
 */
public enum DataType {
    Rainfall("降雨量"),
    Temperature("温度"),
    Radiation("辐射"),
    WindSpeed("风速"),
    Displacement("排水量"),
    Outflow("进水流量"),
    Inflow("出水流量"),
    SoilWaterContent("土壤含水量"),
    GroundWater("地下水位"),
    GroundWaterTemp("地下水温度");
    private String dataType;

    DataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataType() {
        return dataType;
    }
}
