package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    public void equalsTest(){
        Vector2d vec1 = new Vector2d(1, 2);
        Vector2d vec2 = new Vector2d(1, 2);
        Vector2d vec3 = new Vector2d(2, 1);

        Assertions.assertEquals(vec1, vec2);
        Assertions.assertNotEquals(vec1, vec3);
    }

    @Test
    public void toStringTest(){
        Vector2d vec1 = new Vector2d(0,0);

        Assertions.assertEquals(vec1.toString(), "(0,0)");
    }

    @Test
    public void precedesTest(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(2,2);

        Assertions.assertTrue(vec1.precedes(vec2));
        Assertions.assertFalse(vec2.precedes(vec1));
    }

    @Test
    public void followsTest(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(2,2);

        Assertions.assertTrue(vec2.follows(vec1));
        Assertions.assertFalse(vec1.follows(vec2));
    }

    @Test
    public void upperRightTest(){

        Vector2d vec1 = new Vector2d(0,0);
        Vector2d vec2 = new Vector2d(0,1);

        Assertions.assertEquals(vec1.upperRight(vec2), new Vector2d(0, 1));

        Vector2d vec3 = new Vector2d(1,2);
        Vector2d vec4 = new Vector2d(4,1);

        Assertions.assertEquals(vec3.upperRight(vec4), new Vector2d(4, 2));

    }

    @Test
    public void lowerLeftTest(){

        Vector2d vec1 = new Vector2d(0,0);
        Vector2d vec2 = new Vector2d(0,1);

        Assertions.assertEquals(vec1.lowerLeft(vec2), new Vector2d(0, 0));

        Vector2d vec3 = new Vector2d(1,2);
        Vector2d vec4 = new Vector2d(4,1);

        Assertions.assertEquals(vec3.lowerLeft(vec4), new Vector2d(1, 1));

    }

    @Test
    public void addTest(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(0,4);

        Assertions.assertEquals(vec1.add(vec2), new Vector2d(1, 6));
    }

    @Test
    public void subtractTest(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(0,4);

        Assertions.assertEquals(vec1.subtract(vec2), new Vector2d(1, -2));
    }

    @Test
    public void oppositeTest(){
        Vector2d vec1 = new Vector2d(1,2);
        Assertions.assertEquals(vec1.opposite(), new Vector2d(-1, -2));

        Vector2d vec2 = new Vector2d(0,0);
        Assertions.assertEquals(vec2.opposite(), new Vector2d(0, 0));
    }

}
