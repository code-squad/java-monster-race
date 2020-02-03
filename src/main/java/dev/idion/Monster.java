package dev.idion;

public class Monster {
    private int moveCount;

    public void plusMoveCount() {
        this.moveCount++;
    }

    public String getMovingDistance() {
        StringBuilder distanceBuilder = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            distanceBuilder.append("-");
        }
        return distanceBuilder.toString();
    }
}
