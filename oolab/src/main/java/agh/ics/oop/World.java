package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

public class    World {

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
        Animal zwierz = new Animal();
        System.out.println(zwierz.toString());
        System.out.println(OptionsParser.convert(new String[]{"f", "b", "r", "l", "T"}));
    }
}
