package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public class GrassField extends AbstractWorldMap{
    private final int numberOfGrassTiles;
    private final Map<Vector2d, Grass> grassTiles = new HashMap<>();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    public GrassField(int numberOfGrassTiles) {
        this.numberOfGrassTiles = numberOfGrassTiles;
        initializeGrassMap();
    }

    private void initializeGrassMap(){
        int grassFieldDimension = (int) Math.floor(Math.sqrt(numberOfGrassTiles*10)) + 1;
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(grassFieldDimension, grassFieldDimension, numberOfGrassTiles);

        for(Vector2d position: randomPositionGenerator){
            grassTiles.put(position, new Grass(position));
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grassTiles.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {

        if(!canMoveTo(position)){
            return super.objectAt(position);
        }
        else{
            return grassTiles.get(position);
        }
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
    @Override
    public List<WorldElement> getElements(){
        List<WorldElement> elements = super.getElements();
        elements.addAll(grassTiles.values());
        return elements;
    }
    public int getNumberOfGrassTiles(){
        return grassTiles.size();
    }
}

