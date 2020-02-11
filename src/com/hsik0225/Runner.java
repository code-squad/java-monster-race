package com.hsik0225;

public class Runner {
    private final int bound = 10;
    private final int moveCondition = 4;

    @Override
    public void calcMoveCount() {
        moveCount = (int) makeRandomValues(bound, moveCondition).count();
    }
}
