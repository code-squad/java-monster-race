package com.hsik0225;

public class Flight extends Monster {
    public Flight(String name, String type) {
        super(name, type);
    }

    @Override
    public void move(int ATTEMPT_COUNT) {
        int bound = 10;
        int moveCondition = 4;
        int numOfMoves = (int)makeRandomValues(ATTEMPT_COUNT, bound, moveCondition).count()*3;
        setMoveLength("-".repeat(numOfMoves));
    }
}
