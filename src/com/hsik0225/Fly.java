package com.hsik0225;

public class Fly extends Monster implements Movable {
    private final int bound = 10;
    private final int moveCondition = 6;

    public Fly(String name, String type) {
        super(name, type);
    }

    @Override
    public int calcMoveCount() {
        return (int)makeRandomValues(bound, moveCondition).count() * 3;
    }
}
