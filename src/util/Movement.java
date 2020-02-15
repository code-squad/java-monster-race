package util;

public class Movement {
    final int RANDOM_MAX = 10;
    int movePoint;

    public Movement(int movePoint) {
        this.movePoint = movePoint;
    }

    public boolean verifyMovement() {
        int randomNumber = (int) (Math.random() * RANDOM_MAX);
        return (randomNumber >= movePoint);
    }
}
