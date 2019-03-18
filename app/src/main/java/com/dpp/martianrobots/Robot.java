package com.dpp.martianrobots;

public class Robot {

    private Position position;
    private Coordinate grid;

    public Robot(Position position, Coordinate grid) {
        this.position = position;
        this.grid = grid;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Coordinate getGrid() {
        return grid;
    }

    public void setGrid(Coordinate grid) {
        this.grid = grid;
    }

    public String getOutputSequence(String inputSequence) throws Exception {
        checkInputParams(inputSequence);
        for (char letter : inputSequence.toCharArray()) {
            if (letter == 'F') {
                position.getCoordinate().move(position.getOrientation());
                if (checkIfLost(position) != null) {
                    return checkIfLost(position).getX() + " " + checkIfLost(position).getY() + " " + position.getOrientation().getOrientatioName() + " LOST";
                }
            } else if (letter == 'L') {
                changeOrientation(-1);
            } else if (letter == 'R') {
                changeOrientation(1);
            } else {
                throw new Exception("Letter " + letter + " is unknown.");
            }
        }
        return position.getCoordinate().getX() + " " + position.getCoordinate().getY() + " " + position.getOrientation().getOrientatioName();
    }

    private void changeOrientation(int orientationStep) {
        int orientationAux = Orientation.values().length;
        int index = (orientationAux + position.getOrientation().getOrientationValue() + orientationStep) % orientationAux;
        position.setOrientation(Orientation.values()[index]);
    }

    private boolean checkIfXOutEdge() {
        return position.getCoordinate().getX() > grid.getX();
    }

    private boolean checkIfYOutEdge() {
        return position.getCoordinate().getY() > grid.getY();
    }

    private void checkInputParams(String inputSequence) throws Exception {
        if (inputSequence.length() > 100)
            throw new Exception("Input sequence exceeds the length: " + inputSequence);
        if (grid.getX() > 50 || grid.getY() > 50)
            throw new Exception("Coordinate from grid exceeds the value");
        if (position.getCoordinate().getX() > 50 || position.getCoordinate().getY() > 50)
            throw new Exception("Initial coordinate exceeds the value");
    }

    private Coordinate checkIfLost(Position position) {
        Coordinate coordinateBeforeLost = null;
        if (checkIfXOutEdge()) {
            coordinateBeforeLost = new Coordinate(position.getCoordinate().getX() - 1, position.getCoordinate().getY());
        }
        if (checkIfYOutEdge()) {
            coordinateBeforeLost = new Coordinate(position.getCoordinate().getX(), position.getCoordinate().getY() - 1);
        }
        return coordinateBeforeLost;
    }

}
