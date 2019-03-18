package com.dpp.martianrobots;

public class Position {

    public Coordinate coordinate;
    public Orientation orientation;


    public Position(Coordinate coordinate, Orientation orientation) {
        this.orientation = orientation;
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

}
