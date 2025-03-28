package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] dirChars){

        if(dirChars.length == 0){
            throw new IllegalArgumentException("Cannot run the simulation without instructions");
        }

        List<MoveDirection> moveDirections = new ArrayList<>();

        for(String dir: dirChars){
               MoveDirection direction = switch (dir) {
                   case "f", "forward" -> MoveDirection.FORWARD;
                   case "b", "backward" -> MoveDirection.BACKWARD;
                   case "l", "left" -> MoveDirection.LEFT;
                   case "r", "right" -> MoveDirection.RIGHT;
                   default -> throw new IllegalArgumentException(dir + " is not legal move specification");
               };
               moveDirections.add(direction);
        }
        return moveDirections;
    }

}
