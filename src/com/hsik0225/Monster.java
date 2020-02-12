package com.hsik0225;

import java.util.Random;
import java.util.stream.IntStream;

public abstract class Monster {
    private String name;
    private String type;
    private int attemptCount;
    protected int moveCount;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
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

    public abstract void calcMoveCount();
}
