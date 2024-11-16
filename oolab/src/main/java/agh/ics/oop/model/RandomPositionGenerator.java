package agh.ics.oop.model;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomPositionGenerator implements Iterable<Vector2d>{

    private final int maxWidth;
    private final int maxHeight;
    private final int grassCount;
    private final List<Vector2d> grassPossiblePositions;
    private final Random rand;

    private int currentGrassCount = 0;

    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount){
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.grassCount = grassCount;
        rand = new Random();

        grassPossiblePositions = new ArrayList<>(maxWidth*maxHeight);

        initializeGrassArray();
    }

    private void initializeGrassArray(){
        for(int i = 0; i < maxWidth; i++){
            for(int j = 0; j < maxHeight; j++){
                grassPossiblePositions.add(new Vector2d(i, j));
            }
        }
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return currentGrassCount < grassCount;
            }

            @Override
            public Vector2d next() {
                int index = rand.nextInt(maxWidth*maxHeight-currentGrassCount);
                currentGrassCount++;
                return grassPossiblePositions.remove(index);

            }
        };
    }

}
