package agh.ics.oop.model;

import agh.ics.oop.World;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap{

    protected Map<Vector2d, Animal> animals;
    protected MapVisualizer mapVisualizer;

    protected AbstractWorldMap() {
        this.mapVisualizer = new MapVisualizer(this);
        this.animals = new HashMap<>();
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
        return !canMoveTo(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public List<WorldElement> getElements(){
        return new ArrayList<>(animals.values());
    }

}
