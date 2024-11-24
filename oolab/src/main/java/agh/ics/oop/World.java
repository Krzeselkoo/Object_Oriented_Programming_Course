package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class World {

    private static void run(MoveDirection[] directions) {

        for(MoveDirection dir: directions){
            String move = switch(dir){
                case FORWARD -> "Zwierzak idzie do przodu";
                case LEFT -> "Zwierzak skręca w lewo";
                case BACKWARD -> "Zwierzak idzie w tył";
                case RIGHT -> "Zwierzak skręca w prawo";
            };

            System.out.println(move);
        }

    }

    public static void main(String[] args) {
        List<MoveDirection> directions;
//        directions = OptionsParser.parse(args);

        try {
            directions = OptionsParser.parse(args);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        List<Vector2d> positions = List.of(new Vector2d(0,0), new Vector2d(0,1), new Vector2d(0,2),new Vector2d(0,1));
        RectangularMap rectangularMap = new RectangularMap(3,3);

        ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
        rectangularMap.subscribe(consoleMapDisplay);

        Simulation simulation = new Simulation(positions, directions, rectangularMap);
        simulation.run();

//
//            GrassField grassField = new GrassField(2);
//            grassField.place(new Animal(new Vector2d(2,2)));
//        System.out.println(grassField);

    }
}
