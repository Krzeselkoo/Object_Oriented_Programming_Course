package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {

    public static void run(MoveDirection[] direction) {

        for(MoveDirection dir: direction){
            String move = switch(dir){
                case MoveDirection.FORWARD -> "Zwierzak idzie do przodu";
                case MoveDirection.LEFT -> "Zwierzak skręca w lewo";
                case MoveDirection.BACKWARD -> "Zwierzak idzie w tył";
                case MoveDirection.RIGHT -> "Zwierzak skręca w prawo";
                default -> null;
            };

            System.out.println(move);
        }

    }

    public static void main(String[] args) {
        System.out.println("Start");
        run(OptionsParser.convert(args));
        System.out.println("Stop");
    }
}
