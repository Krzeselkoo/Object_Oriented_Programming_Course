package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {


    //Checking if animal is spawned correctly

    @Test
    void animalEmptyConstructor(){
        Animal animal = new Animal();

        Assertions.assertTrue(animal.isAt(Animal.getDefaultPosition()));
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void animalNullPosition(){
        Animal animal = new Animal(null);

        Assertions.assertTrue(animal.isAt(Animal.getDefaultPosition()));
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void animalWithinBoundaries(){
        Vector2d startPosition = new Vector2d(1,1);

        Animal animal = new Animal(startPosition);

        Assertions.assertTrue(animal.isAt(startPosition));
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void animalOutOfBoundaries(){
        Vector2d startPosition = new Vector2d(5,-1);

        Animal animal = new Animal(startPosition);

        Assertions.assertTrue(animal.isAt(Animal.getDefaultPosition()));
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    //Testing turning around

    @Test
    void animalIsTurningRight(){
        Animal animal = new Animal();

        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.EAST, animal.getOrientation());

        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.SOUTH, animal.getOrientation());

        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.WEST, animal.getOrientation());

        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void animalIsTurningLeft(){
        Animal animal = new Animal();

        animal.move(MoveDirection.LEFT);
        Assertions.assertEquals(MapDirection.WEST, animal.getOrientation());

        animal.move(MoveDirection.LEFT);
        Assertions.assertEquals(MapDirection.SOUTH, animal.getOrientation());

        animal.move(MoveDirection.LEFT);
        Assertions.assertEquals(MapDirection.EAST, animal.getOrientation());

        animal.move(MoveDirection.LEFT);
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    //Testing the movement

    @Test
    void animalMoves(){
        Animal animal = new Animal(new Vector2d(0,0));

        animal.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(0,1)));


        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(1,1)));


        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.BACKWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(1,2)));

        animal.move(MoveDirection.BACKWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(1,3)));
    }

    @Test
    void animalTriesGoingOutOfBounds(){
        Animal animalBottom = new Animal(Animal.getBottomLeftCorner());
        Animal animalTop = new Animal(Animal.getTopRightCorner());

        //Bottom animal

        animalBottom.move(MoveDirection.BACKWARD);
        Assertions.assertTrue(animalBottom.isAt(Animal.getBottomLeftCorner()));

        animalBottom.move(MoveDirection.LEFT);
        animalBottom.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animalBottom.isAt(Animal.getBottomLeftCorner()));

        //Top animal

        animalTop.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animalTop.isAt(Animal.getTopRightCorner()));

        animalTop.move(MoveDirection.RIGHT);
        animalTop.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animalTop.isAt(Animal.getTopRightCorner()));
    }

    @Test
    void animalGetsNullDirection(){
        Animal animal = new Animal();

        animal.move(null);

        Assertions.assertTrue(animal.isAt(Animal.getDefaultPosition()));
    }

    //Checking if toString returns correct format

    @Test
    void animalStringCheck(){
        Animal animal = new Animal();

        Assertions.assertEquals("(2,2) NORTH", animal.toString());
    }

}
