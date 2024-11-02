package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<Animal> animals;
    private final List<MoveDirection> moves;

    public Simulation(List<Vector2d> animalPositions, List<MoveDirection> moves){
        this.animals = spawnAnimals(animalPositions);
        this.moves = moves;
    }

    private List<Animal> spawnAnimals(List<Vector2d> positions){
        List<Animal> animals = new ArrayList<>();
        for(Vector2d position: positions){
            animals.add(new Animal(position));
        }
        return animals;
    }

    public void run(){
        if(!animals.isEmpty()) {
            int i = 0;
            for (MoveDirection direction : moves) {
                animals.get(i).move(direction);

                String animalString = animals.get(i).toString();
                System.out.printf(
                        "Zwierzę %d : %s\n".formatted(
                        i + 1,
                        animalString
                        )
                );

                i = i + 1 == animals.size() ? 0 : i + 1;
            }
        }
    }

    public List<Animal> getAnimals(){
        return animals;
    }
}
