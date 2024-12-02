package agh.ics.oop.model;

public class Animal implements WorldElement{

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
                    Vector2d newPosition = position.add(orientation.toUnitVector());
                    if (moveValidator.canMoveTo(newPosition)) {
                        position = newPosition;
                    }
                }
                case BACKWARD -> {
                    Vector2d newPosition = position.subtract(orientation.toUnitVector());
                    if (moveValidator.canMoveTo(newPosition)) {
                        position = newPosition;
                    }
                }
                case LEFT -> orientation = orientation.previous();
                case RIGHT -> orientation = orientation.next();
            }
        }
    }

    public MapDirection getOrientation(){
        return orientation;
    }

    public Vector2d getPosition(){ return position; };

}
