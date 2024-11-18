package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {
    @Test
    void correctMapInitialization(){
        GrassField grassField = new GrassField(5);
        Vector2d position = new Vector2d(3,3);
        Animal animal = new Animal(position);

        try {
            grassField.place(animal);
        }catch (IncorrectPositionException e){
            System.out.println(e);
        }
        Assertions.assertEquals(5, grassField.getNumberOfGrassTiles());
        Assertions.assertTrue(grassField.isOccupied(position));
        Assertions.assertEquals(animal, grassField.objectAt(position));
        Assertions.assertTrue(grassField.canMoveTo(new Vector2d(10,10)));
    }

    @Test
    void movingAroundTheMap(){
        GrassField grassField = new GrassField(3);
        Vector2d position = new Vector2d(3,3);
        Vector2d midPosition = new Vector2d(3,4);
        Vector2d endPosition = new Vector2d(4,4);
        Animal animal = new Animal(position);

        try {
            grassField.place(animal);
        }catch (IncorrectPositionException e){
            System.out.println(e);
        }
        grassField.move(animal, MoveDirection.FORWARD);

        Assertions.assertEquals(3, grassField.getNumberOfGrassTiles());
        Assertions.assertTrue(grassField.isOccupied(midPosition));
        Assertions.assertEquals(animal, grassField.objectAt(midPosition));

        grassField.move(animal, MoveDirection.RIGHT);
        grassField.move(animal, MoveDirection.FORWARD);

        Assertions.assertTrue(grassField.canMoveTo(midPosition));
        Assertions.assertTrue(grassField.isOccupied(endPosition));
        Assertions.assertEquals(animal, grassField.objectAt(endPosition));
    }

    @Test
    void tryingToMoveOntoOccupiedField(){
        GrassField grassField = new GrassField(4);
        Vector2d firstPosition = new Vector2d(3,3);
        Vector2d secondPosition = new Vector2d(3,4);
        Animal firstAnimal = new Animal(firstPosition);
        Animal secondAnimal = new Animal(secondPosition);

        try {
            grassField.place(firstAnimal);
        }catch (IncorrectPositionException e){
            System.out.println(e);
        }

        try {
            grassField.place(secondAnimal);
        }catch (IncorrectPositionException e){
            System.out.println(e);
        }

//        System.out.println(grassField);
//        System.out.println(grassField.getGrass());
//        System.out.println(grassField.getAnimals());
        grassField.move(firstAnimal, MoveDirection.FORWARD);

        Assertions.assertEquals(4, grassField.getNumberOfGrassTiles());
        Assertions.assertFalse(grassField.canMoveTo(secondPosition));
        Assertions.assertTrue(grassField.isOccupied(firstPosition));
        Assertions.assertEquals(firstAnimal, grassField.objectAt(firstPosition));
        Assertions.assertEquals(secondAnimal, grassField.objectAt(secondPosition));
    }
}
