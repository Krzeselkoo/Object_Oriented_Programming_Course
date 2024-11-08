package agh.ics.oop.model;

import java.util.Objects;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;

    public final static Vector2d DEFAULT_STARTING_POSITION = new Vector2d(2, 2);

    public Animal(Vector2d position) {
        this.position = position;
        this.orientation = MapDirection.NORTH;
    }

    public Animal() {
        this(DEFAULT_STARTING_POSITION);
    }

    public String toString(){
        return orientation.getArrow();
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator moveValidator){
        if(direction != null) {
            switch (direction) {
                case FORWARD -> {
                    Vector2d newPosition = position.add(MapDirection.toUnitVector(orientation));
                    if (moveValidator.canMoveTo(newPosition)) {
                        position = newPosition;
                    }
                }
                case BACKWARD -> {
                    Vector2d newPosition = position.subtract(MapDirection.toUnitVector(orientation));
                    if (moveValidator.canMoveTo(newPosition)) {
                        position = newPosition;
                    }
                }
                case LEFT -> orientation = MapDirection.previous(orientation);
                case RIGHT -> orientation = MapDirection.next(orientation);
            }
        }
    }

    public MapDirection getOrientation(){
        return orientation;
    }

    public Vector2d getPosition(){ return position; };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return orientation == animal.orientation && Objects.equals(position, animal.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientation, position);
    }

}
