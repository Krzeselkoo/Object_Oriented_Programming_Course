package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class OptionsParserTest {

    //testing each single correct case

    @Test
    void forwardMovement(){
        String[] inputList = {"f"};

        MoveDirection direction = OptionsParser.convert(inputList)[0];

        Assertions.assertEquals(MoveDirection.FORWARD, direction);
    }

    @Test
    void backwardMovement(){
        String[] inputList = {"b"};

        MoveDirection direction = OptionsParser.convert(inputList)[0];

        Assertions.assertEquals(MoveDirection.BACKWARD, direction);
    }

    @Test
    void rightMovement(){
        String[] inputList = {"r"};

        MoveDirection direction = OptionsParser.convert(inputList)[0];

        Assertions.assertEquals(MoveDirection.RIGHT, direction);
    }

    @Test
    void leftMovement(){
        String[] inputList = {"l"};

        MoveDirection direction = OptionsParser.convert(inputList)[0];

        Assertions.assertEquals(MoveDirection.LEFT, direction);
    }

    //testing single wrong cases

    @Test
    void wrongDirection(){
        String[] direction = {"t"};
        MoveDirection[] emptyArray = {};

        MoveDirection[] directions = OptionsParser.convert(direction);

        Assertions.assertArrayEquals(
                emptyArray,
                directions
        );
    }

    @Test
    void emptyStringPassed(){
        String[] direction = {""};
        MoveDirection[] emptyArray = {};

        MoveDirection[] directions = OptionsParser.convert(direction);

        Assertions.assertArrayEquals(
                emptyArray,
                directions
        );
    }

    @Test
    void emptyStringListPassed(){
        String[] direction = {};
        MoveDirection[] emptyArray = {};

        MoveDirection[] directions = OptionsParser.convert(direction);

        Assertions.assertArrayEquals(
                emptyArray,
                directions
        );
    }

    //Testing multiple instructions

    @Test
    void allGoodDirections(){
        String[] directions = {"f", "b", "r", "l"};
        MoveDirection[] correctOutcome = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT};

        MoveDirection[] convertedDirs = OptionsParser.convert(directions);

        Assertions.assertArrayEquals(
                correctOutcome,
                convertedDirs
        );
    }

    @Test
    void mostGoodDirections(){
        String[] directions = {"f","t","b","t"};
        MoveDirection[] correctOutcome = {MoveDirection.FORWARD, MoveDirection.BACKWARD};

        MoveDirection[] convertedDirs = OptionsParser.convert(directions);

        Assertions.assertArrayEquals(
                correctOutcome,
                convertedDirs
        );

    }

    @Test
    void allWrongDirections(){
        String[] directions = {"o","i","k","t"};
        MoveDirection[] correctOutcome = {};

        MoveDirection[] convertedDirs = OptionsParser.convert(directions);

        Assertions.assertArrayEquals(
                correctOutcome,
                convertedDirs

        );
    }

}
