package agh.ics.oop;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionsParserTest {

    //testing each single correct case

    @Test
    void forwardMovement(){
        String[] inputList = {"f"};

        MoveDirection direction = OptionsParser.parse(inputList).get(0);

        Assertions.assertEquals(MoveDirection.FORWARD, direction);
    }

    @Test
    void backwardMovement(){
        String[] inputList = {"b"};

        MoveDirection direction = OptionsParser.parse(inputList).get(0);

        Assertions.assertEquals(MoveDirection.BACKWARD, direction);
    }

    @Test
    void rightMovement(){
        String[] inputList = {"r"};

        MoveDirection direction = OptionsParser.parse(inputList).get(0);

        Assertions.assertEquals(MoveDirection.RIGHT, direction);
    }

    @Test
    void leftMovement(){
        String[] inputList = {"l"};

        MoveDirection direction = OptionsParser.parse(inputList).get(0);

        Assertions.assertEquals(MoveDirection.LEFT, direction);
    }

    //testing single wrong cases

    @Test
    void wrongDirection(){
        String[] direction = {"t"};
        List<MoveDirection> emptyArray = List.of();

        List<MoveDirection> directions = OptionsParser.parse(direction);

        Assertions.assertEquals(emptyArray, directions);
    }

    @Test
    void emptyStringPassed(){
        String[] direction = {""};
        List<MoveDirection> emptyArray = List.of();

        List<MoveDirection> directions = OptionsParser.parse(direction);

        Assertions.assertEquals(emptyArray, directions);
    }

    @Test
    void emptyStringListPassed(){
        String[] direction = {};
        List<MoveDirection> emptyArray = List.of();

        List<MoveDirection> directions = OptionsParser.parse(direction);

        Assertions.assertEquals(emptyArray, directions);
    }

    //Testing multiple instructions

    @Test
    void allGoodDirections(){
        String[] directions = {"f", "b", "r", "l"};
        List<MoveDirection> correctOutcome = Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT);

        List<MoveDirection> convertedDirs = OptionsParser.parse(directions);

        Assertions.assertEquals(correctOutcome, convertedDirs);
    }

    @Test
    void mostGoodDirections(){
        String[] directions = {"f","t","b","t"};
        List<MoveDirection> correctOutcome = Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD);

        List<MoveDirection> convertedDirs = OptionsParser.parse(directions);

        Assertions.assertEquals(correctOutcome, convertedDirs);

    }

    @Test
    void allWrongDirections(){
        String[] directions = {"o","i","k","t"};
        List<MoveDirection> correctOutcome = List.of();

        List<MoveDirection> convertedDirs = OptionsParser.parse(directions);

        Assertions.assertEquals(correctOutcome, convertedDirs);
    }

}
