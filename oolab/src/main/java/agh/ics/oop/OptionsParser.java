package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] convert(String[] args) {
             MoveDirection[] moveDirections = new MoveDirection[args.length];
             int i = 0;
             for(String dir: args){
                 if(!dir.isEmpty()) {
                     moveDirections[i] = switch (dir) {
                         case "f" -> MoveDirection.FORWARD;
                         case "b" -> MoveDirection.BACKWARD;
                         case "l" -> MoveDirection.LEFT;
                         case "r" -> MoveDirection.RIGHT;
                         default -> throw new IllegalArgumentException("Unknown move direction: " + dir);
                     };
                     i += 1;
                 }
             }
             return moveDirections;

    }
}
