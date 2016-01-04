package models;

/**
 * Created by EriclLee on 15/12/30.
 */
public class Coordinate {
    private float longitude;
    private float latitude;

    public Coordinate(int longitude, int latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }
}
