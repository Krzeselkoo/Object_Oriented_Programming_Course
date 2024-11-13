package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {


    //Checking if animal is spawned correctly

    @Test
    void animalEmptyConstructor(){
        Animal animal = new Animal();

        Assertions.assertTrue(animal.isAt(Animal.DEFAULT_STARTING_POSITION));
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

//    @Test
//    void animalNullPosition(){
//        Animal animal = new Animal(null);
//
//        Assertions.assertTrue(animal.isAt(Animal.DEFAULT_STARTING_POSITION));
//        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
//    }

    @Test
    void animalWithinBoundaries(){
        Vector2d startPosition = new Vector2d(1,1);

        Animal animal = new Animal(startPosition);

        Assertions.assertTrue(animal.isAt(startPosition));
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

//    @Test
//    void animalOutOfBoundaries(){
//        Vector2d startPosition = new Vector2d(5,-1);
//
//        Animal animal = new Animal(startPosition);
//
//        Assertions.assertTrue(animal.isAt(Animal.DEFAULT_STARTING_POSITION));
//        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
//    }

    //Testing turning around

    @Test
    void animalIsTurningRight(){
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4,4);

        animal.move(MoveDirection.RIGHT, rectangularMap);
        Assertions.assertEquals(MapDirection.EAST, animal.getOrientation());

        animal.move(MoveDirection.RIGHT, rectangularMap);
        Assertions.assertEquals(MapDirection.SOUTH, animal.getOrientation());

        animal.move(MoveDirection.RIGHT, rectangularMap);
        Assertions.assertEquals(MapDirection.WEST, animal.getOrientation());

        animal.move(MoveDirection.RIGHT, rectangularMap);
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void animalIsTurningLeft(){
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4,4);

        animal.move(MoveDirection.LEFT, rectangularMap);
        Assertions.assertEquals(MapDirection.WEST, animal.getOrientation());

        animal.move(MoveDirection.LEFT, rectangularMap);
        Assertions.assertEquals(MapDirection.SOUTH, animal.getOrientation());

        animal.move(MoveDirection.LEFT, rectangularMap);
        Assertions.assertEquals(MapDirection.EAST, animal.getOrientation());

        animal.move(MoveDirection.LEFT, rectangularMap);
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    //Testing the movement

    @Test
    void animalMoves(){
        Animal animal = new Animal(new Vector2d(0,0));
        RectangularMap rectangularMap = new RectangularMap(4,4);
        animal.move(MoveDirection.FORWARD, rectangularMap);
        Assertions.assertTrue(animal.isAt(new Vector2d(0,1)));


        animal.move(MoveDirection.RIGHT, rectangularMap);
        animal.move(MoveDirection.FORWARD, rectangularMap);
        Assertions.assertTrue(animal.isAt(new Vector2d(1,1)));


        animal.move(MoveDirection.RIGHT, rectangularMap);
        animal.move(MoveDirection.BACKWARD, rectangularMap);
        Assertions.assertTrue(animal.isAt(new Vector2d(1,2)));

        animal.move(MoveDirection.BACKWARD, rectangularMap);
        Assertions.assertTrue(animal.isAt(new Vector2d(1,3)));
    }

    @Test
    void animalTriesGoingOutOfBounds(){
        RectangularMap rectangularMap = new RectangularMap(4,4);
        Animal animalBottom = new Animal(rectangularMap.getLowLeftCorner());
        Animal animalTop = new Animal(rectangularMap.getTopRightCorner());
        //Bottom animal

        animalBottom.move(MoveDirection.BACKWARD, rectangularMap);
        Assertions.assertTrue(animalBottom.isAt(rectangularMap.getLowLeftCorner()));

        animalBottom.move(MoveDirection.LEFT, rectangularMap);
        animalBottom.move(MoveDirection.FORWARD, rectangularMap);
        Assertions.assertTrue(animalBottom.isAt(rectangularMap.getLowLeftCorner()));

        //Top animal

        animalTop.move(MoveDirection.FORWARD, rectangularMap);
        Assertions.assertTrue(animalTop.isAt(rectangularMap.getTopRightCorner()));

        animalTop.move(MoveDirection.RIGHT, rectangularMap);
        animalTop.move(MoveDirection.FORWARD, rectangularMap);
        Assertions.assertTrue(animalTop.isAt(rectangularMap.getTopRightCorner()));
    }

    @Test
    void animalGetsNullDirection(){
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4,4);

        animal.move(null, rectangularMap);

        Assertions.assertTrue(animal.isAt(Animal.DEFAULT_STARTING_POSITION));
    }

    //Checking if toString returns correct format

    @Test
    void animalStringCheck(){
        Animal animal = new Animal();

        Assertions.assertEquals("^", animal.toString());
    }

}
