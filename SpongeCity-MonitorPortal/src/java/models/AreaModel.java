package models;

import java.util.List;

/**
 * Created by EriclLee on 15/12/30.
 */
public class AreaModel {
    private int id;
    private String name;
    private float size;
    private AreaModel parentArea;
    private List<AreaModel> subArea;
    private List<Coordinate> coordinates;
    private Coordinate centerPoint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public AreaModel getParentArea() {
        return parentArea;
    }

    public void setParentArea(AreaModel parentArea) {
        this.parentArea = parentArea;
    }

    public List<AreaModel> getSubArea() {
        return subArea;
    }

    public void setSubArea(List<AreaModel> subArea) {
        this.subArea = subArea;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {

        if(coordinates.size()>1) {
            this.coordinates = coordinates.subList(1, coordinates.size());
            this.centerPoint = coordinates.get(0);
        }
        else this.coordinates =  null;
    }

    public Coordinate getCenterPoint() {

        return centerPoint;
    }
}

