package agh.ics.oop.model;

public class Vector2d {
        private final int x;
        private final int y;

        public Vector2d(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean precedes(Vector2d vector) {
            return this.x <= vector.x && this.y <= vector.y;
        }

        public boolean follows(Vector2d vector) {
            return this.x >= vector.x && this.y >= vector.y;
        }

        public Vector2d add(Vector2d vector) {
            return new Vector2d(x + vector.x, y + vector.y);
        }

        public Vector2d subtract(Vector2d vector) {
            return new Vector2d(x - vector.x, y - vector.y);
        }

        public Vector2d upperRight(Vector2d other){
            return new Vector2d(Math.max(x, other.x), Math.max(y, other.y));
        }

        public Vector2d lowerLeft(Vector2d other){
            return new Vector2d(Math.min(x, other.x), Math.min(y, other.y));
        }

        public Vector2d opposite(){
            return new Vector2d(-x, -y);
        }

        @Override
        public boolean equals(Object other){

            if (other == this){
                return true;
            }

            if(!(other instanceof Vector2d otherVector)){
                return false;
            }

            return Integer.compare(x, otherVector.x) == 0 && Integer.compare(y, otherVector.y) == 0;
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
