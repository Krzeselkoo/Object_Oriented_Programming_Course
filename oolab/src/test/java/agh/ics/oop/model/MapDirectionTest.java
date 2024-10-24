package agh.ics.oop.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    //.next() tests

    @Test
    void northNext(){
        MapDirection north = MapDirection.NORTH;

        MapDirection northNext = MapDirection.next(north);

        assertEquals(MapDirection.EAST, northNext);
    }

    @Test
    void eastNext(){
        MapDirection east = MapDirection.EAST;

        MapDirection eastNext = MapDirection.next(east);

        assertEquals(MapDirection.SOUTH, eastNext);
    }

    @Test
    void southNext(){
        MapDirection south = MapDirection.SOUTH;

        MapDirection southNext = MapDirection.next(south);

        assertEquals(MapDirection.WEST, southNext);
    }

    @Test
    void westNext(){
        MapDirection west = MapDirection.WEST;

        MapDirection westNext = MapDirection.next(west);

        assertEquals(MapDirection.NORTH, westNext);
    }

    // .previous() tests

    @Test
    void northPrevious(){
        MapDirection north = MapDirection.NORTH;

        MapDirection northPrev = MapDirection.previous(north);

        assertEquals(MapDirection.WEST, northPrev);
    }

    @Test
    void eastPrevious(){
        MapDirection east = MapDirection.EAST;

        MapDirection eastPrev = MapDirection.previous(east);

        assertEquals(MapDirection.NORTH, eastPrev);
    }

    @Test
    void southPrevious(){
        MapDirection south = MapDirection.SOUTH;

        MapDirection southPrev = MapDirection.previous(south);

        assertEquals(MapDirection.EAST, southPrev);
    }

    @Test
    void westPrevious(){
        MapDirection west = MapDirection.WEST;

        MapDirection westPrev = MapDirection.previous(west);

        assertEquals(MapDirection.SOUTH, westPrev);
    }

}

