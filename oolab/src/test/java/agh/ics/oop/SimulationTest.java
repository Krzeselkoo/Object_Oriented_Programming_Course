package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SimulationTest{

    private final Vector2d firstStartingPosition = new Vector2d(2,2);
    private final Vector2d secondStartingPosition = new Vector2d(3,4);

    private final Vector2d firstFinishPosition = new Vector2d(2,3);
    private final Vector2d secondFinishPosition = new Vector2d(3,3);

    private final Vector2d firstFinishOutOfBoundariesPosition = new Vector2d(2,4);

    //Integrated simulation tests will help checking if simulation class works as it should

    @Test
    void allCorrectInstructions(){
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f"});
        List<Vector2d> positions = List.of(firstStartingPosition, secondStartingPosition);
        RectangularMap rectangularMap = new RectangularMap(4,4);

        Simulation simulation = new Simulation(positions, directions, rectangularMap);
        simulation.run();
        List<?> animals = simulation.getAnimals();

        Animal animal1 = (Animal) animals.getFirst();
        Animal animal2 = (Animal) animals.get(1);

        Assertions.assertEquals(2, simulation.getAnimalsCount());

        Assertions.assertEquals(MapDirection.EAST, animal1.getOrientation());
        Assertions.assertTrue(animal1.isAt(firstFinishPosition));

        Assertions.assertEquals(MapDirection.WEST, animal2.getOrientation());
        Assertions.assertTrue(animal2.isAt(secondFinishPosition));
    }

    @Test
    void someCorrectInstructions(){
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "hello", "goodbye", "b", "r", "l", "f", "f", "Hello", "World"});
        List<Vector2d> positions = List.of(firstStartingPosition, secondStartingPosition);
        RectangularMap rectangularMap = new RectangularMap(4,4);

        Simulation simulation = new Simulation(positions, directions, rectangularMap);
        simulation.run();
        List<?> animals = simulation.getAnimals();

        Animal animal1 = (Animal) animals.getFirst();
        Animal animal2 = (Animal) animals.get(1);

        Assertions.assertEquals(2, simulation.getAnimalsCount());

        Assertions.assertEquals(MapDirection.EAST, animal1.getOrientation());
        Assertions.assertTrue(animal1.isAt(firstFinishPosition));

        Assertions.assertEquals(MapDirection.WEST, animal2.getOrientation());
        Assertions.assertTrue(animal2.isAt(secondFinishPosition));
    }

    @Test
    void allWrongInstructions(){
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"It's", "not", "a", "bug", ".", "It's", "a", "feature"});
        List<Vector2d> positions = List.of(firstStartingPosition, secondStartingPosition);
        RectangularMap rectangularMap = new RectangularMap(4,4);

        Simulation simulation = new Simulation(positions, directions, rectangularMap);
        simulation.run();
        List<?> animals = simulation.getAnimals();

        Animal animal1 = (Animal) animals.getFirst();
        Animal animal2 = (Animal) animals.get(1);

        Assertions.assertEquals(2, simulation.getAnimalsCount());

        Assertions.assertEquals(MapDirection.NORTH, animal1.getOrientation());
        Assertions.assertTrue(animal1.isAt(firstStartingPosition));

        Assertions.assertEquals(MapDirection.NORTH, animal2.getOrientation());
        Assertions.assertTrue(animal2.isAt(secondStartingPosition));
    }

    @Test
    void emptyInstructions(){
        List<MoveDirection> directions = OptionsParser.parse(new String[]{});
        List<Vector2d> positions = List.of(firstStartingPosition, secondStartingPosition);
        RectangularMap rectangularMap = new RectangularMap(4,4);

        Simulation simulation = new Simulation(positions, directions, rectangularMap);
        simulation.run();
        List<?> animals = simulation.getAnimals();

        Animal animal1 = (Animal) animals.getFirst();
        Animal animal2 = (Animal) animals.get(1);

        Assertions.assertEquals(2, simulation.getAnimalsCount());

        Assertions.assertEquals(MapDirection.NORTH, animal1.getOrientation());
        Assertions.assertTrue(animal1.isAt(firstStartingPosition));

        Assertions.assertEquals(MapDirection.NORTH, animal2.getOrientation());
        Assertions.assertTrue(animal2.isAt(secondStartingPosition));
    }

    @Test
    void tryingToLeaveTheBounds(){
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "f", "f", "f", "f", "f"});
        List<Vector2d> positions = List.of(firstStartingPosition);
        RectangularMap rectangularMap = new RectangularMap(4,4);

        Simulation simulation = new Simulation(positions, directions, rectangularMap);
        simulation.run();
        List<?> animals = simulation.getAnimals();

        Animal animal1 = (Animal) animals.getFirst();

        Assertions.assertEquals(1, simulation.getAnimalsCount());

        Assertions.assertEquals(MapDirection.NORTH, animal1.getOrientation());
        Assertions.assertTrue(animal1.isAt(firstFinishOutOfBoundariesPosition));
    }

    @Test
    void tryingToPlaceAnimalOnTopOfOther(){
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "b", "r", "l"});
        List<Vector2d> positions = List.of(firstStartingPosition, firstStartingPosition);
        RectangularMap rectangularMap = new RectangularMap(4,4);

        Simulation simulation = new Simulation(positions, directions, rectangularMap);
        simulation.run();

        Assertions.assertEquals(1, simulation.getAnimalsCount());
    }

    @Test
    void tryingToPlaceAnimalOutOfBounds(){
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "b", "r", "l"});
        List<Vector2d> positions = List.of(new Vector2d(2,2));
        RectangularMap rectangularMap = new RectangularMap(1,1);

        Simulation simulation = new Simulation(positions, directions, rectangularMap);
        simulation.run();

        Assertions.assertEquals(0, simulation.getAnimalsCount());
    }

}