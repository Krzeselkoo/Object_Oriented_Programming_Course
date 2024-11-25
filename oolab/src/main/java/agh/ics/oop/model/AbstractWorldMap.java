package agh.ics.oop.model;

import agh.ics.oop.World;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap{

    protected final Map<Vector2d, Animal> animals;
    protected final MapVisualizer mapVisualizer;
    protected final ArrayList<MapChangeListener> subscribers;
    protected final UUID id;
    protected AbstractWorldMap() {
        this.mapVisualizer = new MapVisualizer(this);
        this.animals = new HashMap<>();
        this.subscribers = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    @Override
    public void place(Animal animal) throws IncorrectPositionException{

        if(canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            mapChanged("Animal got placed at position " + animal.getPosition());
        }else{
            throw new IncorrectPositionException(animal.getPosition());
        }
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if(animals.containsValue(animal)){
            Vector2d oldPosition = animal.getPosition();
            MapDirection oldOrientation = animal.getOrientation();

            animals.remove(oldPosition);

            animal.move(direction, this);

            animals.put(animal.getPosition(), animal);

            Vector2d newPosition = animal.getPosition();
            MapDirection newOrientation = animal.getOrientation();
            if(!newPosition.equals(oldPosition)){
                mapChanged("Animal at " + oldPosition + " moved to " + newPosition);
            }else{
                if(newOrientation == oldOrientation){
                    mapChanged("Animal at " + oldPosition + " tried moving to " + oldPosition.add(oldOrientation.toUnitVector()) + " but failed!");
                }else{
                    mapChanged("Animal at " + oldPosition + " turned from " + oldOrientation + " to " + newOrientation);
                }
            }
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

    public void subscribe(MapChangeListener subscriber){
        subscribers.add(subscriber);
    }

    public void unsubscribe(MapChangeListener subscriber){
        subscribers.remove(subscriber);
    }

    protected void mapChanged(String message){
        for(MapChangeListener subscriber: subscribers){
            subscriber.mapChanged(this, message);
        }
    }

    @Override
    public String toString(){
        Boundary boundary = getCurrentBoundary();
        return mapVisualizer.draw(boundary.bottomLeft(), boundary.topRight());
    }

    public UUID getId(){
        return id;
    }

    protected abstract Boundary getCurrentBoundary();

}
