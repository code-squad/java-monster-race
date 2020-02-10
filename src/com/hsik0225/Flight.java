package com.hsik0225;

import java.util.Random;
import java.util.stream.IntStream;

public class Flight implements movable {
    private String name;
    private String type;
    private String moveLength;

    public Monster(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getMoveLength() {
        return moveLength;
    }

    @Override
    public String move(int randomValue) {
        return null;
    }

    private int setNumOfMove(int bound, int moveCondition) {
        Random random = new Random();
        return (int) IntStream.range(0, ATTEMPT_COUNT)
                .map(index -> random.nextInt(bound))
                .filter(randomValue -> randomValue >= moveCondition)
                .count();
    }
}
