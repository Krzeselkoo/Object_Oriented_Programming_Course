package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private List<Animal> animals;
    private List<MoveDirection> moves;

    public Simulation(List<Vector2d> animalPositions, List<MoveDirection> moves){
        this.animals = spawnAnimals(animalPositions);
    }

    private List<Animal> spawnAnimals(List<Vector2d> positions){
        List<Animal> animals = new ArrayList<>();
        for(Vector2d position: positions){
            animals.add(new Animal(position));
        }
        return animals;
    }
}
