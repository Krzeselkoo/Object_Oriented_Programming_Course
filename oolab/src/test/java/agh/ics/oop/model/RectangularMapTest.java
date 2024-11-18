package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {

    @Test
    void correctMapInitialization(){
        RectangularMap rectangularMap = new RectangularMap(5,5);
        Vector2d position = new Vector2d(3,3);
        Animal animal = new Animal(position);
//        String expectedMapString =
//                " y\\x  0 1 2 3 4\r\n" +
//                "  5: -----------\r\n" +
//                "  4: | | | | | |\r\n" +
//                "  3: | | | |^| |\r\n" +
//                "  2: | | | | | |\r\n" +
//                "  1: | | | | | |\r\n" +
//                "  0: | | | | | |\r\n" +
//                " -1: -----------\r\n";

        rectangularMap.place(animal);

        Assertions.assertEquals(new Vector2d(4,4),rectangularMap.getTopRightCorner());
        Assertions.assertTrue(rectangularMap.isOccupied(position));
        Assertions.assertEquals(animal, rectangularMap.objectAt(position));
//        Assertions.assertEquals(expectedMapString,rectangularMap.toString());
        Assertions.assertTrue(rectangularMap.canMoveTo(rectangularMap.getTopRightCorner()));
        Assertions.assertFalse(rectangularMap.canMoveTo(new Vector2d(10,10)));
    }

    @Test
    void movingAroundTheMap(){
        RectangularMap rectangularMap = new RectangularMap(5,5);
        Vector2d position = new Vector2d(3,3);
        Vector2d breakPosition = new Vector2d(3,4);
        Vector2d endPosition = new Vector2d(4,4);
        Animal animal = new Animal(position);

        rectangularMap.place(animal);
        rectangularMap.move(animal, MoveDirection.FORWARD);
        //Trying to leave out of bounds
        rectangularMap.move(animal, MoveDirection.FORWARD);

        Assertions.assertTrue(rectangularMap.isOccupied(breakPosition));
        Assertions.assertEquals(animal, rectangularMap.objectAt(breakPosition));

        rectangularMap.move(animal, MoveDirection.RIGHT);
        rectangularMap.move(animal, MoveDirection.FORWARD);

        Assertions.assertFalse(rectangularMap.isOccupied(breakPosition));
        Assertions.assertTrue(rectangularMap.isOccupied(endPosition));
        Assertions.assertEquals(animal, rectangularMap.objectAt(endPosition));
    }

    @Test
    void tryingToMoveOntoOccupiedField(){
        RectangularMap rectangularMap = new RectangularMap(5,5);
        Vector2d firstPosition = new Vector2d(3,3);
        Vector2d secondPosition = new Vector2d(3,4);
        Animal firstAnimal = new Animal(firstPosition);
        Animal secondAnimal = new Animal(secondPosition);

        rectangularMap.place(firstAnimal);
        rectangularMap.place(secondAnimal);
        rectangularMap.move(firstAnimal, MoveDirection.FORWARD);

        Assertions.assertFalse(rectangularMap.canMoveTo(secondPosition));
        Assertions.assertTrue(rectangularMap.isOccupied(firstPosition));
        Assertions.assertEquals(firstAnimal, rectangularMap.objectAt(firstPosition));
        Assertions.assertEquals(secondAnimal, rectangularMap.objectAt(secondPosition));
    }


}
