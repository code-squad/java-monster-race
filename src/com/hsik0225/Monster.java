package com.hsik0225;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Monster {
    private int numOfMove;

    public Monster(int numOfMove){
        this.numOfMove = numOfMove;
    }

    public String move() {
                .forEach(randomValue -> {
            addLength(stringBuilder, randomValue);
        });
        return stringBuilder.toString();
    }

    public void addLength(StringBuilder stringBuilder, int randomValue) {
        IntStream.range(0, randomValue).forEach(count -> stringBuilder.append("-"));
    }
}
