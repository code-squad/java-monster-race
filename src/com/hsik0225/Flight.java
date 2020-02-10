package com.hsik0225;

public class Flight extends Monster {
    public Flight(String name, String type) {
        super(name, type);
    }

    @Override
    public void move(int attemptCount) {
        int bound = 10;
        int moveCondition = 6;
        int numOfMoves = (int)makeRandomValues(attemptCount, bound, moveCondition).count()*3;

        setMoveLength("-".repeat(numOfMoves));
    }
}
