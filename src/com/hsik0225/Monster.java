package com.hsik0225;

import java.util.Random;
import java.util.stream.IntStream;

public abstract class Monster {
    private String name;
    private String type;
    private int attemptCount;
    protected int moveCount;
    protected Random random;

    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
        random = new Random();
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

    public abstract void calcMoveCount();

    protected IntStream makeRandomValues(int bound, int moveCondition) {
        return IntStream.range(0, attemptCount)
                .map(index -> random.nextInt(bound))
                .filter(randomValue -> randomValue >= moveCondition);
    }

    public String move(){
        return "-".repeat(moveCount);
    }
}
