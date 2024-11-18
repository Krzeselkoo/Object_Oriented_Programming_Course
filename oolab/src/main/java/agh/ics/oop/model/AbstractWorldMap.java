package agh.ics.oop.model;

import agh.ics.oop.World;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap{

    protected final Map<Vector2d, Animal> animals;
    protected final MapVisualizer mapVisualizer;

    protected AbstractWorldMap() {
        this.mapVisualizer = new MapVisualizer(this);
        this.animals = new HashMap<>();
    }

    @Override
    public void place(Animal animal) throws IncorrectPositionException{

        if(canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
        }else{
            throw new IncorrectPositionException(animal.getPosition());
        }
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

    protected abstract Boundary getCurrentBoundary();

}
