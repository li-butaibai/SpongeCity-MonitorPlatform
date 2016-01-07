package models;

/**
 * Created by EriclLee on 15/12/30.
 */
public class Coordinate {
    private String longitude;
    private String latitude;

    public Coordinate(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }
}
