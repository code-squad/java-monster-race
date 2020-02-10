package com.hsik0225;

public class Runner extends Monster {
    public Runner(String name, String type) {
        super(name, type);
    }

    @Override
    public void move(int attemptCount) {
        int bound = 10;
        int moveCondition = 4;
        int numOfMoves = (int)makeRandomValues(attemptCount, bound, moveCondition).count();

        setMoveLength("-".repeat(numOfMoves));
    }
}
