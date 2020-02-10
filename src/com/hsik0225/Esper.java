package com.hsik0225;

import java.util.Random;
import java.util.stream.IntStream;

public class Esper implements movable {
    private String name;
    private String type;
    private String moveLength;
    private int ATTEMPT_COUNT;

    public Esper(String name, String type, int ATTEMPT_COUNT){
        this.name = name;
        this.type = type;
        this.ATTEMPT_COUNT = ATTEMPT_COUNT;
        setMoveLength();
    }

    public String getMoveLength() {
        return moveLength;
    }

    public void setMoveLength() {
        this.moveLength = "-".repeat(move(ATTEMPT_COUNT));
    }

    @Override
    public int move(int ATTEMPT_COUNT) {
        Random random = new Random();
        int bound = 10;
        int moveCondition = 9;

        return (int) IntStream.range(0, ATTEMPT_COUNT)
                .map(index -> random.nextInt(bound))
                .filter(randomValue -> randomValue >= moveCondition)
                .map(randomValue -> random.nextInt(100) + 1)
                .reduce(0, Integer::sum);
    }
}
