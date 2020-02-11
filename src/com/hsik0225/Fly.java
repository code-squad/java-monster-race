package com.hsik0225;

public class Fly extends Monster {
    public Fly(String name, String type) {
        super(name, type);
    }

    @Override
    public void calcMoveCount() {
        int bound = 10;
        int moveCondition = 6;
        moveCount = (int) makeRandomValues(bound, moveCondition).count() * 3;
    }
}
