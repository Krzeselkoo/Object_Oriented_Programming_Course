package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{

    private int updatesReceived = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        updatesReceived++;
        System.out.println("\n" + message + "\n" + worldMap + "Updates received = " + updatesReceived);
    }
}
