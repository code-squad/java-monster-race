package com.hsik0225;

public class Esper extends Monster {
    public Esper(String name, String type) {
        super(name, type);
    }

    @Override
    public void calcMoveCount() {
        int bound = 10;
        int moveCondition = 9;
        moveCount = (int) makeRandomValues(bound, moveCondition)
                .map(randomValue -> random.nextInt(100) + 1)
                .reduce(0, Integer::sum);
    }
}
