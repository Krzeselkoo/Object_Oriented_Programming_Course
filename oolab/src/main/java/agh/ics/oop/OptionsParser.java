package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> convert(String[] dirChars) {
             List<MoveDirection> moveDirections = new ArrayList<MoveDirection>();
             for(String dir: dirChars){
                   MoveDirection direction = switch (dir) {
                         case "f" -> MoveDirection.FORWARD;
                         case "b" -> MoveDirection.BACKWARD;
                         case "l" -> MoveDirection.LEFT;
                         case "r" -> MoveDirection.RIGHT;
                         default -> null;
                   };

                   if(direction != null) moveDirections.add(direction);

                   }
             return moveDirections;
    }

}
