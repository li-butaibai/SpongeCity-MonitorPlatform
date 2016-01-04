package models;

/**
 * Created by EriclLee on 15/12/30.
 */
public enum AlertState {
    Active("活动"),
    Closed("关闭");

    private String alertState;

    private AlertState(String alertState) {
        this.alertState = alertState;
    }

    public String getAlertState() {
        return alertState;
    }
}
