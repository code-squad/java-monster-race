package com.hsik0225;

import java.util.Random;

public class Esper extends Monster implements Movable {
    private final int bound = 10;
    private final int moveCondition = 9;

    public Esper(String name, String type) {
        super(name, type);
    }

    @Override
    public int calcMoveCount() {
        Random random = new Random();
        return (int)makeRandomValues(bound, moveCondition).map(randomValue -> random.nextInt(100) + 1)
                .reduce(0, Integer::sum);
    }
}
