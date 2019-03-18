package com.dpp.martianrobots;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextInputLayout til_upper_rigth_coodinates;
    TextInputEditText tiet_upper_rigth_coodinates;
    TextInputLayout til_initial_coordinates;
    TextInputEditText tiet_initial_coordinates;
    TextInputLayout til_orientation;
    TextInputEditText tiet_orientation;
    TextInputLayout til_input;
    TextInputEditText tiet_input;
    TextView tv_output;

    private Robot robot;
    private Position position;
    private Coordinate coordinate;
    private Coordinate grid;
    private Orientation orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        til_upper_rigth_coodinates = findViewById(R.id.til_upper_rigth_coodinates);
        tiet_upper_rigth_coodinates = findViewById(R.id.tiet_upper_rigth_coodinates);
        til_initial_coordinates = findViewById(R.id.til_initial_coordinates);
        tiet_initial_coordinates = findViewById(R.id.tiet_initial_coordinates);
        til_orientation = findViewById(R.id.til_orientation);
        tiet_orientation = findViewById(R.id.tiet_orientation);
        til_input = findViewById(R.id.til_input);
        tiet_input = findViewById(R.id.tiet_input);
        tv_output = findViewById(R.id.tv_output);
    }

    public void btn_submit(View v) {
        tv_output.setText("");
        if (checkUIErrors()) return;
        String result = calculateOutput(tiet_input.getText().toString());
        tv_output.setText(result);
    }

    public String calculateOutput(String input) {

        if (tiet_orientation.getText().toString().equals("N")) {
            orientation = Orientation.NORTH;
        } else if (tiet_orientation.getText().toString().equals("S")) {
            orientation = Orientation.SOUTH;
        } else if (tiet_orientation.getText().toString().equals("E")) {
            orientation = Orientation.EAST;
        } else if (tiet_orientation.getText().toString().equals("W")) {
            orientation = Orientation.WEST;
        }
        coordinate = new Coordinate(getXPosition(tiet_initial_coordinates.getText().toString()), getYPosition(tiet_initial_coordinates.getText().toString()));
        position = new Position(coordinate, orientation);

        if (grid == null || robot == null || checkIfGridChange(grid)) {
            grid = new Coordinate(getXPosition(tiet_upper_rigth_coodinates.getText().toString()), getYPosition(tiet_upper_rigth_coodinates.getText().toString()));
            robot = new Robot(position, grid);
        } else {
            robot.setPosition(position);
        }

//        if (grid != null) {
//            if (checkIfGridChange(grid)) {
//                grid = new Coordinate(getXPosition(tiet_upper_rigth_coodinates.getText().toString()), getYPosition(tiet_upper_rigth_coodinates.getText().toString()));
//                robot = new Robot(position, grid);
//            }
//        } else {
//            grid = new Coordinate(getXPosition(tiet_upper_rigth_coodinates.getText().toString()), getYPosition(tiet_upper_rigth_coodinates.getText().toString()));
//        }
//
//        if (robot == null) {
//            robot = new Robot(position, grid);
//        } else {
//            robot.setPosition(position);
//            robot.setGrid(grid);
//        }

        String output;
        try {
            output = robot.getOutputSequence(input);
        } catch (Exception exception) {

            output = exception.getMessage();
        }
        return output;
    }

    public int getXPosition(String inputData) {
        return Integer.parseInt(inputData.substring(0, inputData.indexOf(" ")));
    }

    public int getYPosition(String inputData) {
        return Integer.parseInt(inputData.substring(inputData.indexOf(" ") + 1));
    }

    public boolean checkUIErrors() {
        deleteUIErrors();
        if (!tiet_upper_rigth_coodinates.getText().toString().matches("[0-9]{1,2}[ ]{1}[0-9]{1,2}")) {
            til_upper_rigth_coodinates.setError(getString(R.string.ti_upper_rigth_coodinates_error));
            return true;
        }
        if (!tiet_initial_coordinates.getText().toString().matches("[0-9]{1,2}[ ]{1}[0-9]{1,2}")) {
            til_initial_coordinates.setError(getString(R.string.ti_initial_coodinates_error));
            return true;
        }
        if (!(tiet_orientation.getText().toString().matches("[NSEW]"))) {
            til_orientation.setError(getString(R.string.ti_orientation_error));
            return true;
        }
        if (!(tiet_input.getText().toString().matches("[FRL]+"))) {
            til_input.setError(getString(R.string.ti_input_error));
            return true;
        }
        return false;
    }

    public void deleteUIErrors() {
        til_upper_rigth_coodinates.setError(null);
        til_initial_coordinates.setError(null);
        til_orientation.setError(null);
        til_input.setError(null);
    }

    public boolean checkIfGridChange(Coordinate grid) {
        Coordinate newGrid = new Coordinate(getXPosition(tiet_upper_rigth_coodinates.getText().toString()), getYPosition(tiet_upper_rigth_coodinates.getText().toString()));
        return (!newGrid.equals(grid));
    }

}
