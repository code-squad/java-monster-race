package com.hsik0225;

import java.util.Random;
import java.util.stream.IntStream;

public class Flight implements Movable {
    private String name;
    private String type;
    private String moveLength;

    public Flight(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String type() {
        return this.type = type;
    }

    @Override
    public String moveLength() {
        return this.moveLength;
    }

    @Override
    public void move(int ATTEMPT_COUNT) {
        Random random = new Random();
        int bound = 10;
        int moveCondition = 6;
        int moveLength = (int) IntStream.range(0, ATTEMPT_COUNT)
                .map(index -> random.nextInt(bound))
                .filter(randomValue -> randomValue >= moveCondition)
                .count() * 3;

        this.moveLength = "-".repeat(moveLength);
    }
}
