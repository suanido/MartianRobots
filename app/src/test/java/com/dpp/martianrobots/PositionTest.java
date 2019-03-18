package com.dpp.martianrobots;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    private final int x = 1;
    private final int y = 2;
    public Orientation orientation = Orientation.NORTH;
    private Position position;
    Coordinate coordinate;

    @Before
    public void initPositionTest() {
        coordinate = new Coordinate(x, y);
        position = new Position(coordinate, orientation);
    }

    @Test
    public void checkPositionParams() {
        assertThat(position.getCoordinate().getX()).isEqualTo(x);
        assertThat(position.getCoordinate().getY()).isEqualTo(y);
        assertThat(position.getOrientation()).isEqualToComparingFieldByField(orientation);
    }

}
