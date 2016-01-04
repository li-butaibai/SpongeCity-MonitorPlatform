package models;

/**
 * Created by EriclLee on 15/12/30.
 */
public enum DeviceState {
    Online("在线"),
    Offline("离线"),
    Unknown("未知");
    private String deviceState;
    public String getDeviceState() {
        return deviceState;
    }
    private DeviceState(String deviceState){
        this.deviceState = deviceState;
    }
}
