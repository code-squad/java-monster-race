package com.hsik0225;

public class Esper {
    private final int bound = 10;
    private final int moveCondition = 9;

    @Override
    public void calcMoveCount() {
        moveCount = (int) makeRandomValues(bound, moveCondition)
                .map(randomValue -> random.nextInt(100) + 1)
                .reduce(0, Integer::sum);
    }
}
