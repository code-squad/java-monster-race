package com.hsik0225;

import java.util.Random;
import java.util.stream.IntStream;
public abstract class Monster {
    private String name;
    private String type;
    private String moveLength;
    protected Random random;

    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
        random = new Random();
    }

    public void setMoveLength(String moveLength) {
        this.moveLength = moveLength;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getMoveLength() {
        return this.moveLength;
    }

    public IntStream makeRandomValues(int ATTEMPT_COUNT, int bound, int moveCondition){
        return IntStream.range(0, ATTEMPT_COUNT)
                .map(index -> random.nextInt(bound))
                .filter(randomValue -> randomValue >= moveCondition);
    }

    public abstract void move(int ATTEMPT_COUNT);
}
