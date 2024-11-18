package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{

    private final Boundary boundary;

    private final Vector2d lowLeftCorner;
    private final Vector2d topRightCorner;


    public RectangularMap(int width, int height) {
        lowLeftCorner = new Vector2d(0,0);
        topRightCorner = new Vector2d(width-1, height-1);
        boundary = new Boundary(new Vector2d(0,0), topRightCorner);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && position.precedes(topRightCorner) && position.follows(lowLeftCorner);
    }

    public Vector2d getLowLeftCorner(){
        return lowLeftCorner;
    }

    public Vector2d getTopRightCorner(){
        return topRightCorner;
    }

    @Override
    public String toString(){
        return mapVisualizer.draw(boundary.bottomLeft(), boundary.topRight());
    }

    @Override
    public Boundary getCurrentBoundary(){
        return boundary;
    }
}
