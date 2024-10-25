package agh.ics.oop.model;

import java.util.Objects;

public class Vector2d {
        private final int x;
        private final int y;

        public Vector2d(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean precedes(Vector2d other) {
            return x <= other.getX() && y <= other.getY();
        }

        public boolean follows(Vector2d other) {
            return x >= other.getX() && y >= other.getY();
        }

        public Vector2d add(Vector2d other) {
            return new Vector2d(x + other.getX(), y + other.getY());
        }

        public Vector2d subtract(Vector2d other) {
            return new Vector2d(x - other.getX(), y - other.getY());
        }

        public Vector2d upperRight(Vector2d other){
            return new Vector2d(Math.max(x, other.getX()), Math.max(y, other.getY())    );
        }

        public Vector2d lowerLeft(Vector2d other){
            return new Vector2d(Math.min(x, other.getX()), Math.min(y, other.getY()));
        }

        public Vector2d opposite(){
            return new Vector2d(-x, -y);
        }

        @Override
        public int hashCode(){
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object other){

            if(other == this){
                return true;
            }

            if(other == null){
                return false;
            }

            if(!(other instanceof Vector2d otherVector)){
                return false;
            }

            return x == otherVector.getX() && y == otherVector.getY();
        }

        @Override
        public String toString(){
            return "(" + x + "," + y + ")";
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
}
