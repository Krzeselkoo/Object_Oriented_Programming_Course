package agh.ics.oop.model.util;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;

public class ConsoleMapDisplay implements MapChangeListener {

    private int updatesReceived = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        synchronized (System.out) {
            updatesReceived++;
            System.out.println("\n" + worldMap.getId() + "\n" + message + "\n" + worldMap + "Updates received = " + updatesReceived);
        }
    }
}
