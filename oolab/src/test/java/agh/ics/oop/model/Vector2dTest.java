package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {

    //.equals() tests

    @Test
    void equalityDifferentVectorObjectSameAttributes(){
        Vector2d vec1 = new Vector2d(1, 2);
        Vector2d vec2 = new Vector2d(1, 2);

        boolean vectorsAreEqual = vec1.equals(vec2);
        boolean vectorsAreEqualBackwards = vec2.equals(vec1);

        Assertions.assertTrue(vectorsAreEqual);
        Assertions.assertTrue(vectorsAreEqualBackwards);
    }

    @Test
    void equalitySameObjectReferences(){
        Vector2d vec1 = new Vector2d(1, 2);
        Vector2d vec2 = vec1;

        boolean vectorsAreEqual = vec1.equals(vec2);

        Assertions.assertTrue(vectorsAreEqual);
    }

    @Test
    void equalityNull(){
        Vector2d vec1 = new Vector2d(1, 2);

        boolean vectorsAreEqual = vec1.equals(null);

        Assertions.assertFalse(vectorsAreEqual);
    }

    @Test
    void equalityDifferentVector(){
        Vector2d vec1 = new Vector2d(1, 2);
        Vector2d vec2 = new Vector2d(2, 1);

        boolean vectorsAreEqual = vec1.equals(vec2);

        Assertions.assertFalse(vectorsAreEqual);
    }

    @Test
    void equalityDifferentObject(){
        Vector2d vec1 = new Vector2d(1, 2);
        Object o = new Object();

        boolean vectorsAreEqual = vec1.equals(o);

        Assertions.assertFalse(vectorsAreEqual);
    }

    //.toString() test

    @Test
    void toStringOutput(){
        Vector2d vec1 = new Vector2d(-1,1);

        String outcome = vec1.toString();

        Assertions.assertEquals("(-1,1)", vec1.toString());
    }

    //.precedes() tests

    @Test
    void precedesTrue(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(2,2);

        boolean outcome = vec1.precedes(vec2);

        Assertions.assertTrue(outcome);
    }

    @Test
    void precedesFalse(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(2,2);

        boolean outcome = vec2.precedes(vec1);

        Assertions.assertFalse(outcome);
    }

    //.follows() tests

    @Test
    void followsTrue(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(2,2);

        boolean outcome = vec2.follows(vec1);

        Assertions.assertTrue(outcome);
    }

    @Test
    void followsFalse(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(2,2);

        boolean outcome = vec1.follows(vec2);

        Assertions.assertFalse(outcome);
    }

    //.upperRight() test. It should output the upper right corner of a rectangle which vertices are points v1, v2.
    //If the points are on the same x or y coordinate, it should return the one further to the right.

    @Test
    void upperRightCorner(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(4,1);
        Vector2d corner = new Vector2d(4, 2);

        Vector2d calculatedCorner = vec1.upperRight(vec2);

        Assertions.assertEquals(corner, calculatedCorner);
    }

    //.lowerLeft() test. It should output the lower left corner of a rectangle, which vertices are points v1, v2.
    //If the points are on the same x or y coordinate, it should return the one further to the left.

    @Test
    void lowerLeftCorner(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(4,1);
        Vector2d corner = new Vector2d(1, 1);

        Vector2d calculatedCorner = vec1.lowerLeft(vec2);

        Assertions.assertEquals(corner, calculatedCorner);
    }

    //.add() test

    @Test
    void additionOfVectors(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(0,4);
        Vector2d correctOutcome = new Vector2d(1, 6);

        Vector2d calculatedOutcome = vec1.add(vec2);

        Assertions.assertEquals(correctOutcome, calculatedOutcome);
    }

    //.subtract() test

    @Test
    void subtractTest(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(0,4);
        Vector2d correctOutcome = new Vector2d(1, -2);

        Vector2d calculatedOutcome = vec1.subtract(vec2);

        Assertions.assertEquals(correctOutcome, calculatedOutcome);
    }

    //.opposite() test

    @Test
    void oppositeTest(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec1Opposite = new Vector2d(-1, -2);

        Vector2d calculatedOpposite = vec1.opposite();

        Assertions.assertEquals(vec1Opposite, calculatedOpposite);
    }

}
