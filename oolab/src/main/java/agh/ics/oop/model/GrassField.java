package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public class GrassField implements WorldMap{
    private final int numberOfGrassTiles;
    private final Vector2d topRightCorner;
    private final Map<Vector2d, Grass> grassTiles = new HashMap<>();
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    public GrassField(int numberOfGrassTiles) {
        this.numberOfGrassTiles = numberOfGrassTiles;
        this.topRightCorner = setGrassMapSize();
        initializeGrassMap();
    }

    private Vector2d setGrassMapSize(){
        int x = (int) Math.floor(Math.sqrt(numberOfGrassTiles*10));
        return new Vector2d(x,x);
    }

    private void initializeGrassMap(){
        Random rand = new Random();

        //Może lepiej będzie z listami?

        while(grassTiles.size() < numberOfGrassTiles){
            int grassX = rand.nextInt(topRightCorner.getX() + 1);
            int grassY = rand.nextInt(topRightCorner.getY() + 1);
            Vector2d newGrassPosition = new Vector2d(grassX,grassY);

            if(!grassTiles.containsKey(newGrassPosition)){
                grassTiles.put(newGrassPosition, new Grass(newGrassPosition));
            }
        }
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            return true;
        }

        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if(animals.containsValue(animal)){
            animals.remove(animal.getPosition());

            animal.move(direction, this);

            animals.put(animal.getPosition(), animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position) || grassTiles.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {

        if(!canMoveTo(position)){
            return animals.get(position);
        }
        else{
            return grassTiles.get(position);
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public String toString(){
        List<Vector2d> calculatedVectors = calculateCornersForDraw();
        return mapVisualizer.draw(calculatedVectors.getFirst(),calculatedVectors.getLast());
    }
    private List<Vector2d> calculateCornersForDraw(){

        Vector2d[] calculatedCorners = {null, null};

        Set<Vector2d> allPositions = new HashSet<>();
        allPositions.addAll(grassTiles.keySet());
        allPositions.addAll(animals.keySet());

        for(Vector2d position: allPositions){
            if(calculatedCorners[0] != null){
                calculatedCorners[0] = calculatedCorners[0].lowerLeft(position);
                calculatedCorners[1] = calculatedCorners[1].upperRight(position);
            }else{
                calculatedCorners[0] = position;
                calculatedCorners[1] = position;
            }
        }

        return List.of(calculatedCorners);
    }

    public int getNumberOfGrassTiles(){
        return grassTiles.size();
    }
}

