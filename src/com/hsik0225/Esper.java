package com.hsik0225;

import java.util.Random;

public class Esper extends Monster {
    public Esper(String name, String type) {
        super(name, type);
    }

    @Override
    public void move(int ATTEMPT_COUNT) {
        Random random = new Random();
        int bound = 10;
        int moveCondition = 4;
        int numOfMoves = (int)makeRandomValues(ATTEMPT_COUNT, bound, moveCondition).map(randomValue -> random.nextInt(100)+1).reduce(0, Integer::sum);
        setMoveLength("-".repeat(numOfMoves));
    }
}
