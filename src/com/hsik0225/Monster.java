package com.hsik0225;

import java.util.Random;
import java.util.stream.IntStream;

public class Monster {
    private String name;
    private String type;
    private int attemptCount;
    private int moveCount;
    private Movable movable;

    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
        this.movable = MonsterFactory.valueOf(type).getMovable();
    }

    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getMoveCount(){
        return this.moveCount;
    }

    protected IntStream makeRandomValues(int bound, int moveCondition) {
        Random random = new Random();
        return IntStream.range(0, attemptCount)
                .map(index -> random.nextInt(bound))
                .filter(randomValue -> randomValue >= moveCondition);
    }

    public String move(){
        return "-".repeat(moveCount);
    }

    public void setMoveCount(){
        this.moveCount = movable.calcMoveCount(makeRandomValues(b));
    }
}
