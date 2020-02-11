package com.hsik0225;

public class Runner extends Monster {
    public Runner(String name, String type) {
        super(name, type);
    }

    @Override
    public void calcMoveCount() {
        int bound = 10;
        int moveCondition = 10;
        moveCount = (int) makeRandomValues(bound, moveCondition).count();
    }
}
