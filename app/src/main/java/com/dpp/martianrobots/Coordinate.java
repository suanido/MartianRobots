package com.dpp.martianrobots;

public class Coordinate {

    private int x;
    private int y;

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
