package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<> animals;
    private final List moves;
    private final WorldMap worldMap;
    private int animalsCount = 0;
    public <T,P> Simulation(List<P> animalPositions, List<T> moves, WorldMap<T,P> worldMap) {
        this.animals = spawnAnimals(animalPositions);
        this.moves = moves;
        this.worldMap = worldMap;
    }

    private List<Animal> spawnAnimals(List positions){
        List<Animal> animals = new ArrayList<>();
        for(Object position: positions){
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
                worldMap.move(animal, move);

                i = i + 1 == animalsCount ? 0 : i+1;

                System.out.println(worldMap);
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
