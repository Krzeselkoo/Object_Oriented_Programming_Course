package agh.ics.oop.model;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    public Animal(Vector2d position) {
        this.orientation = MapDirection.NORTH;
        this.position = position;
    }

    public Animal() {
        this(new Vector2d(2, 2));
    }

    public String toString(){
        return orientation.toString() + " " + position.toString();
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        switch (direction){
            case FORWARD -> {
                Vector2d newPosition = position.add(MapDirection.toUnitVector(orientation));
                if (newPosition.precedes(new Vector2d(4,4)) && newPosition.follows(new Vector2d(0,0))){
                    position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = position.subtract(MapDirection.toUnitVector(orientation));
                if (newPosition.precedes(new Vector2d(4,4)) && newPosition.follows(new Vector2d(0,0))){
                    position = newPosition;
                }
            }
            case LEFT -> orientation = MapDirection.previous(orientation);
            case RIGHT -> orientation = MapDirection.next(orientation);
        }
    }

}
