package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField implements WorldMap{
    private final int numberOfGrassTiles;
    private final Vector2d lowLeftCorner = new Vector2d(0, 0);
    private final Vector2d topRightCorner;
    private final Map<Vector2d, Grass> grassMap = new HashMap<>();
    private final Map<Vector2d, Animal> animalMap = new HashMap<>();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    public GrassField(int numberOfGrassTiles) {
        this.numberOfGrassTiles = numberOfGrassTiles;
        this.topRightCorner = setMapSize();
        initializeGrassMap();
    }

    private Vector2d setMapSize(){
        int x = (int) Math.floor(Math.sqrt(numberOfGrassTiles*10));
        return new Vector2d(x,x);
    }

    private void initializeGrassMap(){
        Random rand = new Random();

        //Może lepiej będzie z listami?

        while(grassMap.size() < numberOfGrassTiles){
            int grassX = rand.nextInt(topRightCorner.getX() + 1);
            int grassY = rand.nextInt(topRightCorner.getY() + 1);
            Vector2d newGrassPosition = new Vector2d(grassX,grassY);

            if(!grassMap.containsKey(newGrassPosition)){
                grassMap.put(newGrassPosition, new Grass(newGrassPosition));
            }
        }
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animalMap.containsKey(position) || grassMap.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if(isOccupied(position)){
            return animalMap.get(position);
        }if(grassMap.containsKey(position)){
            return grassMap.get(position);
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public String toString(){
        return mapVisualizer.draw(lowLeftCorner, topRightCorner);
    }
}
