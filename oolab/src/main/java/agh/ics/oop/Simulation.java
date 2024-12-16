package agh.ics.oop;

import agh.ics.oop.model.*;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;

public class Simulation implements Runnable {

    private final List<Animal> animals;
    private final List<MoveDirection> moves;
    private final WorldMap worldMap;
    private int animalsCount = 0;

    public Simulation(List<Vector2d> animalPositions, List<MoveDirection> moves, WorldMap worldMap) {
        this.worldMap = worldMap;
        this.moves = moves;
        this.animals = spawnAnimals(animalPositions);
        animalsCount = animals.size();
    }

    private List<Animal> spawnAnimals(List<Vector2d> positions){
        List<Animal> animals = new ArrayList<>();

        for(Vector2d position: positions){
            Animal animal = new Animal(position);
            try{
                worldMap.place(animal);
                animals.add(animal);
            }
            catch(IncorrectPositionException e){
                System.out.println(e.getMessage());
            }
        }

        return animals;
    }

    public void run(){

        if(animalsCount > 0){
            int i = 0;
            for (MoveDirection move : moves) {
                try{
                    Thread.sleep(1000);
                    Animal animal = animals.get(i);
                    worldMap.move(animal, move);

                    i = (i + 1) % animalsCount;
                }
                catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
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
