package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<Animal> animals;
    private final List<MoveDirection> moves;
    private final WorldMap worldMap;
    private int animalsCount = 0;
    public Simulation(List<Vector2d> animalPositions, List<MoveDirection> moves, WorldMap worldMap) {
        this.animals = spawnAnimals(animalPositions);
        this.moves = moves;
        this.worldMap = worldMap;
    }

    private List<Animal> spawnAnimals(List<Vector2d> positions){
        List<Animal> animals = new ArrayList<>();
        for(Vector2d position: positions){
            animals.add(new Animal(position));
        }
        return animals;
    }

    public void run(){
        List<Animal> placedAnimals = new ArrayList<>(animals.size());

        for(Animal animal: animals){
            if(worldMap.place(animal)){
                placedAnimals.add(animal);
            }
        }

        animalsCount = placedAnimals.size();

        if(animalsCount > 0){
            int i = 0;
            for (MoveDirection move : moves) {

                Animal animal = placedAnimals.get(i);

                if( animal != null) {
                    worldMap.move(animal, move);
                }

                System.out.println(worldMap);

                i = i + 1 == placedAnimals.size() ? 0 : i+1;
            }
        }
    }

    public List<Animal> getAnimals(){
        return List.copyOf(animals);
    }

    public int getAnimalsCount(){
        return animalsCount;
    }
}
