package com.hsik0225;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Monster {
    int numOfMonster;
    int numOfMove;

    public String move() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, numOfMove)
                .map(count -> random.nextInt(10))
                .filter(randomValue -> randomValue >= 4)
                .forEach(randomValue -> {
                    addLength(stringBuilder, randomValue);
                });
        return stringBuilder.toString();
    }

    public void addLength(StringBuilder stringBuilder, int randomValue) {
        IntStream.range(0, randomValue).forEach(count -> stringBuilder.append("-"));
    }
}
