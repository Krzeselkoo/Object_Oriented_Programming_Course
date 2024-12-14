package agh.ics.oop.model;

import java.util.*;

public class GrassField extends AbstractWorldMap{
    private final int numberOfGrassTiles;
    private final Map<Vector2d, Grass> grassTiles = new HashMap<>();

    public GrassField(int numberOfGrassTiles) {
        this.numberOfGrassTiles = numberOfGrassTiles;
        initializeGrassMap();
    }

    private void initializeGrassMap(){
        Random rand = new Random();
        int grassFieldWidth = (int) Math.floor(Math.sqrt(numberOfGrassTiles*10)) + 1;

        List<Vector2d> grassTilesPossibleTiles = new ArrayList<>(grassFieldWidth*grassFieldWidth);

        for(int i = 0; i < grassFieldWidth; i++){
            for(int j = 0; j < grassFieldWidth; j++){
                grassTilesPossibleTiles.add(new Vector2d(i, j));
            }
        }

        for(int i = 0; i < numberOfGrassTiles; i++){
            int index = rand.nextInt(grassTilesPossibleTiles.size() - i);
            Vector2d grassPosition = grassTilesPossibleTiles.remove(index);
            grassTiles.put(grassPosition,new Grass(grassPosition));
            mapChanged("Grass got placed at postion" + grassPosition);
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

    private Boundary calculateBoundary(){

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

        return new Boundary(calculatedCorners[0], calculatedCorners[1]);
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

    @Override
    public Boundary getCurrentBoundary(){
        return calculateBoundary();
    }
}

