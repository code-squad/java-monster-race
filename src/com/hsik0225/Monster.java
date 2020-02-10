package com.hsik0225;

import java.util.Random;
import java.util.stream.IntStream;

public class Monster {
    private String name;
    private MonsterType monsterType;
    private String moveLength;
    protected Random random;

    public Monster(String name, MonsterType monsterType) {
        this.name = name;
        this.monsterType = monsterType;
        random = new Random();
    }

    public void setMoveLength(String moveLength) {
        this.moveLength = moveLength;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return monsterType.name();
    }

    public String getMoveLength() {
        return this.moveLength;
    }

    public IntStream makeRandomValues(int attemptCount, int bound, int moveCondition){
        return IntStream.range(0, attemptCount)
                .map(index -> random.nextInt(bound))
                .filter(randomValue -> randomValue >= moveCondition);
    }

    public void move(int attemptCount){
        this.moveLength = "-".repeat(monsterType.move(this, attemptCount));
    }
}
