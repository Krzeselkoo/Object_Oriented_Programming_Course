package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] convert(String[] dirChars) {
             MoveDirection[] moveDirections = new MoveDirection[dirChars.length];
             int i = 0;
             for(String dir: dirChars){
                   moveDirections[i] = switch (dir) {
                         case "f" -> MoveDirection.FORWARD;
                         case "b" -> MoveDirection.BACKWARD;
                         case "l" -> MoveDirection.LEFT;
                         case "r" -> MoveDirection.RIGHT;
                         default -> null;
                   };

                   i = moveDirections[i] != null ? i + 1: i;
             }
             return Arrays.copyOfRange(moveDirections, 0, i);
    }

}
