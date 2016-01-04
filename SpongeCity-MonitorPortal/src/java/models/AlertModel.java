package models;

import java.util.Date;

/**
 * Created by EriclLee on 15/12/30.
 */
public class AlertModel {
    private int id;
    private String title;
    private Date createtime;
    private DeviceModel device;
    private String comments;
    private Date endtime;
    private AlertState state;
    private int level;
}
