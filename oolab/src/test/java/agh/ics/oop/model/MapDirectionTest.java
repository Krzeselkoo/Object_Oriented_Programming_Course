package agh.ics.oop.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void nextTest(){

        assertEquals(MapDirection.next(MapDirection.NORTH), MapDirection.EAST);
        assertEquals(MapDirection.next(MapDirection.EAST), MapDirection.SOUTH);
        assertEquals(MapDirection.next(MapDirection.SOUTH), MapDirection.WEST);
        assertEquals(MapDirection.next(MapDirection.WEST), MapDirection.NORTH);

    }

    @Test
    public void previousTest(){

        assertEquals(MapDirection.previous(MapDirection.NORTH), MapDirection.WEST);
        assertEquals(MapDirection.previous(MapDirection.WEST), MapDirection.SOUTH);
        assertEquals(MapDirection.previous(MapDirection.SOUTH), MapDirection.EAST);
        assertEquals(MapDirection.previous(MapDirection.EAST), MapDirection.NORTH);

    }

}

