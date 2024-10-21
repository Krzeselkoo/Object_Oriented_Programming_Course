package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class OptionsParserTest {

    @Test
    public void singleArgsTest(){

        Assertions.assertEquals(OptionsParser.convert(new String[]{"f"})[0], MoveDirection.FORWARD);
        Assertions.assertEquals(OptionsParser.convert(new String[]{"b"})[0], MoveDirection.BACKWARD);
        Assertions.assertEquals(OptionsParser.convert(new String[]{"l"})[0], MoveDirection.LEFT);
        Assertions.assertEquals(OptionsParser.convert(new String[]{"r"})[0], MoveDirection.RIGHT);

        MoveDirection[] emptyArray = {};

        Assertions.assertArrayEquals(
                OptionsParser.convert(new String[]{"t"}),
                emptyArray
        );

        Assertions.assertArrayEquals(
                OptionsParser.convert(new String[]{""}),
                emptyArray
        );

    }

    @Test
    public void multipleArgsTest(){

        Assertions.assertArrayEquals(
                OptionsParser.convert(new String[]{"f", "b", "r", "l"}),
                new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT}
        );

        Assertions.assertArrayEquals(
                OptionsParser.convert(new String[]{"f","t","b","t"}),
                new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.BACKWARD}
        );


        MoveDirection[] emptyArray = {};

        Assertions.assertArrayEquals(
                OptionsParser.convert(new String[]{"o","i","k","t"}),
                emptyArray
        );

    }

}
