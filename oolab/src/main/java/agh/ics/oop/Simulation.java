package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<Animal> animals;
    private final List<MoveDirection> moves;
    private final WorldMap worldMap;

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

        int i = 0;
        for (MoveDirection move : moves) {
            worldMap.move(animals.get(index), move);
        }
//        if(!animals.isEmpty()) {
//            int i = 0;
//            for (MoveDirection direction : moves) {
//                animals.get(i).move(direction);
//
//                String animalString = animals.get(i).toString();
//                System.out.printf(
//                        "Zwierzę %d : %s\n".formatted(
//                        i + 1,
//                        animalString
//                        )
//                );
//
//                i = i + 1 == animals.size() ? 0 : i + 1;
//            }
//        }
    }

    public List<Animal> getAnimals(){
        return List.copyOf(animals);
    }
}
