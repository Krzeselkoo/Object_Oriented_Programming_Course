package agh.ics.oop.model;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    public final static Vector2d TOP_RIGHT_CORNER = new Vector2d(4,4);
    public final static Vector2d LOW_LEFT_CORNER = new Vector2d(0,0);
    public final static Vector2d DEFAULT_STARTING_POSITION = new Vector2d(2, 2);
    public Animal(Vector2d position) {

        if(position.precedes(TOP_RIGHT_CORNER) && position.follows(LOW_LEFT_CORNER)) {
            this.position = position;
        }else{
            this.position = DEFAULT_STARTING_POSITION;
        }

        this.orientation = MapDirection.NORTH;
    }

    public Animal() {
        this(DEFAULT_STARTING_POSITION);
    }

    public String toString(){
        return "%s %s".formatted(position.toString(), orientation.toString());
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        if(direction != null) {
            switch (direction) {
                case FORWARD -> {
                    Vector2d newPosition = position.add(MapDirection.toUnitVector(orientation));
                    if (newPosition.precedes(TOP_RIGHT_CORNER) && newPosition.follows(LOW_LEFT_CORNER)) {
                        position = newPosition;
                    }
                }
                case BACKWARD -> {
                    Vector2d newPosition = position.subtract(MapDirection.toUnitVector(orientation));
                    if (newPosition.precedes(TOP_RIGHT_CORNER) && newPosition.follows(LOW_LEFT_CORNER)) {
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

}
