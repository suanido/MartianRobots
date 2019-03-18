package com.dpp.martianrobots;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RobotTest {

    private Robot robot;
    private Position position;
    private Coordinate coordinate;
    private Coordinate grid;
    private Orientation orientation = Orientation.NORTH;
    private int x = 1;
    private int y = 2;
    private int xMaxPosition = 50;
    private int yMaxPosition = 50;

    @Before
    public void initRobotTest() {
        coordinate = new Coordinate(x, y);
        position = new Position(coordinate, orientation);
        grid = new Coordinate(xMaxPosition, yMaxPosition);
        robot = new Robot(position, grid);
    }

    @Test
    public void checkRobotParams() {
        assertThat(robot.getPosition().getCoordinate().getX()).isEqualTo(x);
        assertThat(robot.getPosition().getCoordinate().getY()).isEqualTo(y);
        assertThat(robot.getGrid().getX()).isEqualTo(xMaxPosition);
        assertThat(robot.getGrid().getY()).isEqualTo(yMaxPosition);
        assertThat(robot.getGrid()).isEqualToComparingFieldByField(grid);
        assertThat(robot.getPosition().getCoordinate()).isEqualToComparingFieldByField(coordinate);
        assertThat(robot.getPosition().getOrientation()).isEqualTo(orientation);
    }

    @Test(expected = Exception.class)
    public void receiveUnkmownLetterhouldThrowException() throws Exception {
        robot.getOutputSequence("FFRLLLFRAFR");
    }

    @Test(expected = Exception.class)
    public void inputSequenceExceededhouldThrowException() throws Exception {
        robot.getOutputSequence("FRFRFRFRFRRFRFRFRFRRFRFRRFRRRFRFRFRFRFRRFRFRFRFRFRFRFRFRFRFFRFFRFRFFRFRFFRFRFRRFRFRFFRFRFRFRFFRFRFRFR");
    }

    @Test(expected = Exception.class)
    public void inputParamsFromGridIncorrectdhouldThrowException() throws Exception {
        coordinate = new Coordinate(1, 2);
        grid = new Coordinate(51, 50);
        position = new Position(coordinate, Orientation.NORTH);
        robot = new Robot(position, grid);
        robot.getOutputSequence("LFLFF");
    }

    @Test(expected = Exception.class)
    public void inputParamsFromCoordinateIncorrectdhouldThrowException() throws Exception {
        coordinate = new Coordinate(51, 2);
        grid = new Coordinate(50, 50);
        position = new Position(coordinate, Orientation.NORTH);
        robot = new Robot(position, grid);
        robot.getOutputSequence("LFLFF");
    }

    @Test
    public void inputSequenceComeBackToZero() throws Exception {
        coordinate = new Coordinate(1, 2);
        grid = new Coordinate(50, 50);
        position = new Position(coordinate, Orientation.NORTH);
        robot = new Robot(position, grid);
        robot.getOutputSequence("LFLFF");
        assertThat(robot.getPosition().getCoordinate().getX()).isEqualTo(0);
        assertThat(robot.getPosition().getCoordinate().getY()).isEqualTo(0);
        assertThat(robot.getPosition().getOrientation()).isEqualToComparingFieldByField(Orientation.SOUTH);
    }

    @Test
    public void inputSequenceLost() throws Exception {
        coordinate = new Coordinate(3, 2);
        grid = new Coordinate(5, 3);
        position = new Position(coordinate, Orientation.NORTH);
        robot = new Robot(position, grid);
        String output = robot.getOutputSequence("FRRFLLFFRRFLL");
        assertThat(output).contains("LOST");
    }




}
