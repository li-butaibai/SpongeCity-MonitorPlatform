package models;

/**
 * Created by EriclLee on 15/12/30.
 */
public enum AlertLevel {
    CRITICAL("严重"),
    MAJOR("主要"),
    MINOR("次要"),
    WARNING("警告");
    private String alertLevel;

    private AlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    public String getAlertLevel() {
        return alertLevel;
    }
}
