package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EriclLee on 15/12/30.
 */
public enum DeviceState {
    Online("online"),
    Offline("offline"),
    Unknown("unknown");

    private String text;

    DeviceState(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    // Implementing a fromString method on an enum type
    private static final Map<String, DeviceState> stringToEnum = new HashMap<String, DeviceState>();
    static {
        // Initialize map from constant name to enum constant
        for(DeviceState blah : values()) {
            stringToEnum.put(blah.toString(), blah);
        }
    }

    // Returns Blah for string, or null if string is invalid
    public static DeviceState fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    @Override
    public String toString() {
        return text;
    }

//    private HashMap<String, DeviceState> stringMap= new HashMap<String, DeviceState>();
//    private String deviceState;
//    public String getDeviceState() {
//        return deviceState;
//    }
//    private DeviceState(String deviceState){
//        this.deviceState = deviceState;
//    }
}
