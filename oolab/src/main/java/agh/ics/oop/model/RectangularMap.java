package agh.ics.oop.model;
public class RectangularMap extends AbstractWorldMap{

    private final Boundary boundary;

    private final Vector2d lowLeftCorner;
    private final Vector2d topRightCorner;


    public RectangularMap(int width, int height) {
        lowLeftCorner = new Vector2d(0,0);
        topRightCorner = new Vector2d(width-1, height-1);
        boundary = new Boundary(lowLeftCorner, topRightCorner);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && position.precedes(topRightCorner) && position.follows(lowLeftCorner);
    }

    @Override
    public Boundary getCurrentBoundary(){
        return boundary;
    }
}
