package agh.ics.oop.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void nextTest(){
        assertEquals(MapDirection.next(MapDirection.NORTH), MapDirection.EAST);
    }
}

