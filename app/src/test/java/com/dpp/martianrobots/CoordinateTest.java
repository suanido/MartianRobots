package com.dpp.martianrobots;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateTest {

    private final int x = 1;
    private final int y = 2;
    Coordinate coordinate;

    @Before
    public void initCoordinateTest() {
        coordinate = new Coordinate(x, y);
    }

    @Test
    public void checkCoordinateParams() {
        assertThat(coordinate.getX()).isEqualTo(x);
        assertThat(coordinate.getY()).isEqualTo(y);
    }

    @Test
    public void moveShouldIncreaseYWhenDirectionIsNorth() {
        Coordinate expected = new Coordinate(x, y + 1);
        coordinate.move(Orientation.NORTH);
        assertThat(coordinate).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveShouldDecreaseYWhenDirectionIsSouth() {
        Coordinate expected = new Coordinate(x, y - 1);
        coordinate.move(Orientation.SOUTH);
        assertThat(coordinate).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveShouldIncreaseXWhenDirectionIsEast() {
        Coordinate expected = new Coordinate(x + 1, y);
        coordinate.move(Orientation.EAST);
        assertThat(coordinate).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveShouldDecreaseXWhenDirectionIsNorth() {
        Coordinate expected = new Coordinate(x - 1, y);
        coordinate.move(Orientation.WEST);
        assertThat(coordinate).isEqualToComparingFieldByField(expected);
    }

}
