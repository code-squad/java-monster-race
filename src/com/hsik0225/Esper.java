package com.hsik0225;

public class Esper {
    @Override
    public int move(Monster monster, int attemptCount) {
        int bound = 10;
        int moveCondition = 9;
        int numOfMoves = (int) monster.makeRandomValues(attemptCount, bound, moveCondition)
                .map(randomValue -> monster.random.nextInt(100) + 1)
                .reduce(0, Integer::sum);
        return numOfMoves;
    }
}
