package agh.ics.oop.model;

public enum MapDirection {
    NORTH(new Vector2d(0,1), "NORTH","^"),
    EAST(new Vector2d(1,0), "EAST",">"),
    SOUTH(new Vector2d(0,-1), "SOUTH","v"),
    WEST(new Vector2d(-1,0), "WEST", "<");

    private final Vector2d vector;
    private final String stringDir;
    private final String arrow;

    MapDirection(Vector2d vector, String stringDir, String arrow) {
        this.vector = vector;
        this.stringDir = stringDir;
        this.arrow = arrow;
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

    public String toString() {
        return stringDir;
    }

    public String getArrow(){return arrow;}
}
