package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap{

    public final static Vector2d LOW_LEFT_CORNER = new Vector2d(0,0);
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final int height;
    private final int width;
    private final Vector2d topRightCorner;


    RectangularMap(int width, int height) {
        this.height = height;
        this.width = width;
        topRightCorner = new Vector2d(width, height);
    }


    @Override
    public boolean place(Animal animal) {
        if(animals.containsKey(animal.getPosition())){
            return false;
        }

        animals.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        animals.remove(animal.getPosition());

        animal.move(direction, this);

        animals.put(animal.getPosition(), animal);
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
        return !animals.containsKey(position) && (position.precedes(topRightCorner) && position.follows(LOW_LEFT_CORNER));
    }

}
