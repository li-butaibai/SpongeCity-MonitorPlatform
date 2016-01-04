package models;

import java.util.List;

/**
 * Created by EriclLee on 15/12/30.
 */
public class AreaModel {
    private int id;
    private String name;
    private int size;
    private AreaModel parentArea;
    private AreaModel[] subArea;
    private List<Coordinate> coordinates;

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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public AreaModel getParentArea() {
        return parentArea;
    }

    public void setParentArea(AreaModel parentArea) {
        this.parentArea = parentArea;
    }

    public AreaModel[] getSubArea() {
        return subArea;
    }

    public void setSubArea(AreaModel[] subArea) {
        this.subArea = subArea;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }
}

