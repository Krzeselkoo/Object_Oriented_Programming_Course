package agh.ics.oop.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    //.next() tests

    @Test
    void northNext(){
        MapDirection north = MapDirection.NORTH;

        MapDirection northNext = north.next();

        assertEquals(MapDirection.EAST, northNext);
    }

    @Test
    void eastNext(){
        MapDirection east = MapDirection.EAST;

        MapDirection eastNext = east.next();

        assertEquals(MapDirection.SOUTH, eastNext);
    }

    @Test
    void southNext(){
        MapDirection south = MapDirection.SOUTH;

        MapDirection southNext = south.next();

        assertEquals(MapDirection.WEST, southNext);
    }

    @Test
    void westNext(){
        MapDirection west = MapDirection.WEST;

        MapDirection westNext = west.next();

        assertEquals(MapDirection.NORTH, westNext);
    }

    // .previous() tests

    @Test
    void northPrevious(){
        MapDirection north = MapDirection.NORTH;

        MapDirection northPrev = north.previous();

        assertEquals(MapDirection.WEST, northPrev);
    }

    @Test
    void eastPrevious(){
        MapDirection east = MapDirection.EAST;

        MapDirection eastPrev = east.previous();

        assertEquals(MapDirection.NORTH, eastPrev);
    }

    @Test
    void southPrevious(){
        MapDirection south = MapDirection.SOUTH;

        MapDirection southPrev = south.previous();

        assertEquals(MapDirection.EAST, southPrev);
    }

    @Test
    void westPrevious(){
        MapDirection west = MapDirection.WEST;

        MapDirection westPrev = west.previous();

        assertEquals(MapDirection.SOUTH, westPrev);
    }

    @Test
    void northUnitVector(){
        MapDirection north = MapDirection.NORTH;
        Vector2d correctVec = new Vector2d(0, 1);

        Vector2d unitVector = north.toUnitVector();

        assertEquals(correctVec, unitVector);
    }

    @Test
    void northToString(){
        MapDirection north = MapDirection.NORTH;

        String correctString = north.toString();

        assertEquals("NORTH", correctString);
    }

}

