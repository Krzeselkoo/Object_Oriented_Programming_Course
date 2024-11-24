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
        try{
            MoveDirection direction = OptionsParser.parse(inputList).get(0);
            Assertions.assertEquals(MoveDirection.FORWARD, direction);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    void backwardMovement(){
        String[] inputList = {"b"};

        try{
            MoveDirection direction = OptionsParser.parse(inputList).get(0);
            Assertions.assertEquals(MoveDirection.BACKWARD, direction);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void rightMovement(){
        String[] inputList = {"r"};
        MoveDirection direction;

        try{
            direction = OptionsParser.parse(inputList).get(0);
            Assertions.assertEquals(MoveDirection.RIGHT, direction);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    void leftMovement(){
        String[] inputList = {"l"};
        MoveDirection direction;

        try{
            direction = OptionsParser.parse(inputList).get(0);
            Assertions.assertEquals(MoveDirection.LEFT, direction);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

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
