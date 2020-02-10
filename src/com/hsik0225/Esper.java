package com.hsik0225;

import java.util.Random;
import java.util.stream.IntStream;

public class Esper implements Movable {
    private String name;
    private String type;
    private String moveLength;

    public Esper(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String type() {
        return this.type;
    }

    @Override
    public String moveLength() {
        return this.moveLength;
    }

    @Override
    public void move(int ATTEMPT_COUNT) {
        Random random = new Random();
        int bound = 10;
        int moveCondition = 9;
        int moveLength = (int) IntStream.range(0, ATTEMPT_COUNT)
                .map(index -> random.nextInt(bound))
                .filter(randomValue -> randomValue >= moveCondition)
                .map(randomValue -> random.nextInt(100) + 1)
                .reduce(0, Integer::sum);

        this.moveLength =  "-".repeat(moveLength);
    }
}
