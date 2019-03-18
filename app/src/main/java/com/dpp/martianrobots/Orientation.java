package com.dpp.martianrobots;

public enum Orientation {

    NORTH("N", 0),
    EAST("E", 1),
    SOUTH("S", 2),
    WEST("W", 3);

    private String orientatioName;
    private int orientationValue;

    Orientation(String orientatioName, int orientationValue) {
        this.orientatioName = orientatioName;
        this.orientationValue = orientationValue;
    }

    public String getOrientatioName() {
        return orientatioName;
    }

    public void setOrientatioName(String orientatioName) {
        this.orientatioName = orientatioName;
    }

    public int getOrientationValue() {
        return orientationValue;
    }

    public void setOrientationValue(int orientationValue) {
        this.orientationValue = orientationValue;
    }
}
