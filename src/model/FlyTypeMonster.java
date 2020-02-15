package model;

import util.Movement;

public class FlyTypeMonster implements Monster {
    private String name;
    private final String TYPE = "비행";
    private final int MOVE_POINT = 6;
    private int distance = 0;

    public FlyTypeMonster(String name) {
        this.name = name;
    }

    public void move() {
        Movement movement = new Movement(MOVE_POINT);
        if (movement.verifyMovement()){
            distance += 3;
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
