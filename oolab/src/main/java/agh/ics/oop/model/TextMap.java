package agh.ics.oop.model;

import java.util.*;

public class TextMap implements WorldNumberPositionMap<String, Integer>{

    //Moim głównym założeniem jest to, że nie ma duplikatów słów oraz
    //uznajemy, że słowa dostają instrukcję w kolejności w jakiej są podane na początku
    //(dodanie kolejnych słów powoduje dodanie je na koniec 'words')

    private final ArrayList<String> map;
    private final ArrayList<String> words;

    public TextMap(ArrayList<String> words){
        this.words = words;
        this.map = new ArrayList<>(words);
    }

    @Override
    public boolean canMoveTo(Integer position) {
        return position >= 0 && position < map.size();
    }

    @Override
    public boolean place(String text) {

        if(canBePlaced(text)) {
            words.add(text);
            map.add(text);
            return true;
        }

        return false;
    }

    private boolean canBePlaced(String text){
        return !words.contains(text);
    }

    @Override
    public void move(String text, MoveDirection direction) {
        int currentPosition = map.indexOf(text);

        int moveDirection = switch(direction){
            case FORWARD, RIGHT -> 1;
            case LEFT,BACKWARD -> -1;
        };

        int nextPosition = currentPosition + moveDirection;

        if(canMoveTo(nextPosition)){
            map.set(currentPosition, map.get(nextPosition));
            map.set(nextPosition, text);
        }
    }

    @Override
    public boolean isOccupied(Integer position) {
        return position < map.size();
    }

    @Override
    public String objectAt(Integer position) {
        return map.get(position);
    }

    @Override
    public List<String> initialize(List<Integer> positions) {
        return words;
    }

    @Override
    public String toString(){
        return map.toString();
    }
}
