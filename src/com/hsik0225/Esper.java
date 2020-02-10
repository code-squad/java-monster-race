package com.hsik0225;

public class Esper extends Monster {
    public Esper(String name, String type) {
        super(name, type);
    }

    @Override
    public void move(int attemptCount) {
        int bound = 10;
        int moveCondition = 9;
        int numOfMoves = (int)makeRandomValues(attemptCount, bound, moveCondition)
                .map(randomValue -> random.nextInt(100)+1)
                .reduce(0, Integer::sum);

        setMoveLength("-".repeat(numOfMoves));
    }
}
