package model;

import util.Movement;

public class RunTypeMonster implements Monster {
    private String name;
    private final String TYPE = "달리기";
    private final int MOVE_POINT = 4;
    private int distance = 0;

    public RunTypeMonster(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        Movement move = new Movement(MOVE_POINT);
        if (move.verifyMovement()){
            distance += 1;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        StringBuilder total = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            total.append("-");
        }
        return name + "[" + TYPE + "]: " + total.toString();
    }
}
