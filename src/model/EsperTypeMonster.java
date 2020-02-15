package model;

import util.Movement;

public class EsperTypeMonster implements Monster {
    private String name;
    private final String TYPE = "에스퍼";
    private final int MOVE_POINT = 9;
    private int distance = 0;

    public EsperTypeMonster(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        Movement move = new Movement(MOVE_POINT);
        if (move.verifyMovement()){
            distance += (int)(Math.random()*98) + 1;;
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
