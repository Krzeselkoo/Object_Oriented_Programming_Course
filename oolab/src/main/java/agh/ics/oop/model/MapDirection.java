package agh.ics.oop.model;

public enum MapDirection {
    NORTH, EAST, SOUTH, WEST;

    public static MapDirection next(MapDirection direction) {
        return values()[(direction.ordinal() + 1)%4];
    }

    public static MapDirection previous(MapDirection direction) {
        return values()[(direction.ordinal() + 3)%4];
    }

    public static Vector2d toUnitVector(MapDirection direction) {
        return switch (direction) {
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
        };
    }
}
