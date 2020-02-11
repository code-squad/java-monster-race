package com.hsik0225;

public class Fly {
    private final int bound = 10;
    private final int moveCondition = 6;

    @Override
    public void calcMoveCount() {
        moveCount = (int) makeRandomValues(bound, moveCondition).count() * 3;
    }
}
