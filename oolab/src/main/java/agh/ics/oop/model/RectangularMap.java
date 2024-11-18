package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{

    private final Vector2d lowLeftCorner = new Vector2d(0,0);
    private final Vector2d topRightCorner;


    public RectangularMap(int width, int height) {
        topRightCorner = new Vector2d(width-1, height-1);
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
        return mapVisualizer.draw(lowLeftCorner, topRightCorner);
    }

}
