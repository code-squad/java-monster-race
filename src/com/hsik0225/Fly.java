package com.hsik0225;

public class Fly {
    @Override
    public int move(Monster monster, int attemptCount) {
        int bound = 10;
        int moveCondition = 6;
        int numOfMoves = (int) monster.makeRandomValues(attemptCount, bound, moveCondition).count() * 3;
        return numOfMoves;
    }
}
