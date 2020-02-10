package com.hsik0225;

public class Runner extends Monster implements Movable {
    public Runner(String name, String type) {
        super(name, type);
    }

    @Override
    public void move(int ATTEMPT_COUNT) {
        int bound = 10;
        int moveCondition = 4;
        int numOfMoves = (int)makeRandomValues(ATTEMPT_COUNT, bound, moveCondition).count();
        setMoveLength("-".repeat(numOfMoves));
    }
}
