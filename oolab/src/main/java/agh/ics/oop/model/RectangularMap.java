package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap implements WorldMap<Animal, Vector2d>{

    public final static Vector2d LOW_LEFT_CORNER = new Vector2d(0,0);
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final Vector2d topRightCorner;
    private final MapVisualizer mapVisualizer;


    public RectangularMap(int width, int height) {
        topRightCorner = new Vector2d(width, height);
        this.mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public List<Animal> initialize(List<Vector2d> positions){
        List<Animal> animals = new ArrayList<>();

        for(Vector2d position: positions){
            if(canMoveTo(position)) {
                Animal animal = new Animal(position);

                animals.add(animal);
                this.animals.put(position, animal);
            }
        }

        return animals;
    }

    @Override
    public boolean place(Animal animal) {

        if(canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            return true;
        }

        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if(animals.containsValue(animal)){
            animals.remove(animal.getPosition());

            animal.move(direction, this);

            animals.put(animal.getPosition(), animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && (position.precedes(topRightCorner) && position.follows(LOW_LEFT_CORNER));
    }
    public Vector2d getTopRightCorner(){
        return topRightCorner;
    }

    @Override
    public String toString(){
        return mapVisualizer.draw(LOW_LEFT_CORNER, topRightCorner);
    }

}
