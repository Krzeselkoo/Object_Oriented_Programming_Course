package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

public class World {

    private static void run(MoveDirection[] directions) {

        for(MoveDirection dir: directions){
            String move = switch(dir){
                case MoveDirection.FORWARD -> "Zwierzak idzie do przodu";
                case MoveDirection.LEFT -> "Zwierzak skręca w lewo";
                case MoveDirection.BACKWARD -> "Zwierzak idzie w tył";
                case MoveDirection.RIGHT -> "Zwierzak skręca w prawo";
            };

            System.out.println(move);
        }

    }

    public static void main(String[] args) {

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println();

        System.out.println(MapDirection.next(MapDirection.NORTH)+", expected EAST");
        System.out.println(MapDirection.previous(MapDirection.NORTH)+", expected WEST");
        System.out.println(MapDirection.toUnitVector(MapDirection.NORTH)+", expected (0,1)");

    }
}
