package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class OptionsParserTest {

    //testing each single correct case

    @Test
    void forwardMovement(){
        String[] inputList = {"f"};

        Assertions.assertDoesNotThrow(() -> Assertions.assertEquals(MoveDirection.FORWARD, OptionsParser.parse(inputList).get(0)));
    }

    @Test
    void backwardMovement(){
        String[] inputList = {"b"};

        Assertions.assertDoesNotThrow(() -> Assertions.assertEquals(MoveDirection.BACKWARD, OptionsParser.parse(inputList).get(0)));
    }

    @Test
    void rightMovement(){
        String[] inputList = {"r"};

        Assertions.assertDoesNotThrow(() -> Assertions.assertEquals(MoveDirection.RIGHT, OptionsParser.parse(inputList).get(0)));
    }

    @Test
    void leftMovement(){
        String[] inputList = {"l"};

        Assertions.assertDoesNotThrow(() -> Assertions.assertEquals(MoveDirection.LEFT, OptionsParser.parse(inputList).get(0)));
    }

    //testing single wrong cases

    @Test
    void wrongDirection(){
        String[] direction = {"t"};

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> OptionsParser.parse(direction));
    }

    @Test
    void emptyStringPassed(){
        String[] direction = {""};

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> OptionsParser.parse(direction));
    }

    @Test
    void emptyStringListPassed(){
        String[] direction = {};

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> OptionsParser.parse(direction));
    }

    //Testing multiple instructions

    @Test
    void allGoodDirections(){
        String[] directions = {"f", "b", "r", "l"};
        List<MoveDirection> correctOutcome = Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT);

        Assertions.assertDoesNotThrow(() -> {
            List<MoveDirection> convertedDirs = OptionsParser.parse(directions);
            Assertions.assertEquals(correctOutcome, convertedDirs);
        });
    }

    @Test
    void mostGoodDirections(){
        String[] directions = {"f","t","b","t"};

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> OptionsParser.parse(directions));
    }

    @Test
    void allWrongDirections(){
        String[] directions = {"o","i","k","t"};

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> OptionsParser.parse(directions));
    }

}
