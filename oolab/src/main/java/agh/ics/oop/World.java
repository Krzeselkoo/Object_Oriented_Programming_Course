package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.ConsoleMapDisplay;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class    World {

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


        try {
            List<MoveDirection> directions = OptionsParser.parse(args);
            List<Vector2d> positions = List.of(new Vector2d(0,0), new Vector2d(0,1), new Vector2d(0,2),new Vector2d(0,1));

//            GrassField grassField = new GrassField(3);
//            RectangularMap rectangularMap = new RectangularMap(4,4);

            List<Simulation> simulations = new ArrayList<>();
            ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();

            for(int i = 0; i < 10000; i++){
                GrassField grassField1 = new GrassField(4);
                grassField1.subscribe(consoleMapDisplay);
                simulations.add(new Simulation(positions,directions,grassField1));
            }

//            grassField.subscribe(consoleMapDisplay);
//            rectangularMap.subscribe(consoleMapDisplay);
//
//            Simulation simulationRectangular = new Simulation(positions, directions, rectangularMap);
//            Simulation simulationGrass = new Simulation(positions, directions, grassField);

            SimulationEngine simulationEngine = new SimulationEngine(simulations);
            simulationEngine.runAsyncInThreadPool();
            Instant start = Instant.now();
            simulationEngine.awaitSimulationsEnd();
            Instant end = Instant.now();

            System.out.println( Duration.between(start, end).toMillis() + " ms");
            System.out.println("System zakończył działanie");

//            GrassField grassField = new GrassField(2);
//            grassField.place(new Animal(new Vector2d(2,2)));
//            System.out.println(grassField);

        }catch(IllegalArgumentException | InterruptedException e){
            System.out.println(e.getMessage());
        }



    }
}
