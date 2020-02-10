package com.hsik0225;

import java.util.Random;
import java.util.stream.IntStream;

public class Flight implements movable {
    private String name;
    private String type;
    private String moveLength;

    public Flight(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getMoveLength() {
        return moveLength;
    }

    @Override
    public int move(int ATTEMPT_COUNT) {
        Random random = new Random();
        int bound = 10;
        int moveCondition =6;

        return (int) IntStream.range(0, ATTEMPT_COUNT)
                .map(index -> random.nextInt(bound))
                .filter(randomValue -> randomValue >= moveCondition)
                .count()*3;
    }
}
