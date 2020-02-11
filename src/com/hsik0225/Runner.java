package com.hsik0225;

public class Runner {
    @Override
    public int move(Monster monster, int attemptCount) {
        int bound = 10;
        int moveCondition = 4;
        int numOfMoves = (int) monster.makeRandomValues(attemptCount, bound, moveCondition).count();
        return numOfMoves;
    }
}
