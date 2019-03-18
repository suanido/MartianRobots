package com.dpp.martianrobots;

import java.util.Objects;

public class Coordinate {

    private int x;
    private int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    protected void move(Orientation orientation) {
        int xAux = x;
        int yAux = y;
        switch (orientation) {
            case NORTH:
                yAux = y + 1;
                break;
            case EAST:
                xAux = x + 1;
                break;
            case SOUTH:
                yAux = y - 1;
                break;
            case WEST:
                xAux = x - 1;
                break;
        }
        setX(xAux);
        setY(yAux);
    }
}
