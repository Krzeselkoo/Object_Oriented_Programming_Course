package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation<T,P> {

    private final List<T> animals;
    private final List<MoveDirection> moves;
    private final WorldMap<T,P> worldMap;
    private int animalsCount;
    public Simulation(List<P> animalPositions, List<MoveDirection> moves, WorldMap<T,P>  worldMap) {
        this.moves = moves;
        this.worldMap = worldMap;
        this.animals = worldMap.initialize(animalPositions);
        animalsCount = animals.size();
    }

    public void run(){
        animalsCount = animals.size();
        if(animalsCount > 0){
            int i = 0;
            for (MoveDirection move : moves) {
                worldMap.move(animals.get(i), move);

                i = i + 1 == animalsCount ? 0 : i+1;

                System.out.println(worldMap);
            }
        }

    }

    public List<?> getAnimals(){
        return List.copyOf(animals);
    }

    public int getAnimalsCount(){
        return animalsCount;
    }
}
