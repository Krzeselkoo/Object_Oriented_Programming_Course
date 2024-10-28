package agh.ics.oop.model;

public enum MapDirection {
    NORTH(new Vector2d(0,1), "NORTH"),
    EAST(new Vector2d(1,0), "EAST"),
    SOUTH(new Vector2d(0,-1), "SOUTH"),
    WEST(new Vector2d(-1,0), "WEST");

    private final Vector2d vector;
    private final String stringDir;

    MapDirection(Vector2d vector, String stringDir) {
        this.vector = vector;
        this.stringDir = stringDir;
    }
    public static MapDirection next(MapDirection direction) {
        return values()[(direction.ordinal() + 1)%4];
    }

    public static MapDirection previous(MapDirection direction) {
        return values()[(direction.ordinal() + 3)%4];
    }

    public static Vector2d toUnitVector(MapDirection direction) {
        return direction.vector;
    }

    public String toString(MapDirection direction) {
        return stringDir;
    }
}
