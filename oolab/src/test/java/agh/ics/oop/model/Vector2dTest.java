package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    void equalityTrue(){
        Vector2d vec1 = new Vector2d(1, 2);
        Vector2d vec2 = new Vector2d(1, 2);

        boolean vectorsAreEqual = vec1.equals(vec2);

        Assertions.assertTrue(vectorsAreEqual);
    }

    @Test
    void equalityFalse(){
        Vector2d vec1 = new Vector2d(1, 2);
        Vector2d vec2 = new Vector2d(2, 1);

        boolean vectorsAreEqual = vec1.equals(vec2);

        Assertions.assertFalse(vectorsAreEqual);
    }

    @Test
    void toStringOutput(){
        Vector2d vec1 = new Vector2d(0,0);

        String outcome = vec1.toString();

        Assertions.assertEquals("(0,0)", vec1.toString());
    }

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



    @Test
    void upperRightCorner(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(4,1);
        Vector2d corner = new Vector2d(4, 2);

        Vector2d calculatedCorner = vec1.upperRight(vec2);

        Assertions.assertEquals(corner, calculatedCorner);

    }

    @Test
    void lowerLeftCorner(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(4,1);
        Vector2d corner = new Vector2d(1, 1);

        Vector2d calculatedCorner = vec1.lowerLeft(vec2);

        Assertions.assertEquals(corner, calculatedCorner);

    }

    @Test
    void additionOfVectors(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(0,4);
        Vector2d correctOutcome = new Vector2d(1, 6);

        Vector2d calculatedOutcome = vec1.add(vec2);

        Assertions.assertEquals(correctOutcome, calculatedOutcome);
    }

    @Test
    void subtractTest(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(0,4);
        Vector2d correctOutcome = new Vector2d(1, -2);

        Vector2d calculatedOutcome = vec1.subtract(vec2);

        Assertions.assertEquals(correctOutcome, calculatedOutcome);
    }

    @Test
    void oppositeTest(){
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec1Opposite = new Vector2d(-1, -2);

        Vector2d calculatedOpposite = vec1.opposite();

        Assertions.assertEquals(vec1Opposite, calculatedOpposite);
    }

}
