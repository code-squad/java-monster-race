package com.hsik0225;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Monster {
    private String moveLength;

    public String getMoveLength() {
        return moveLength;
    }

    public void move(int numOfMove) {
        this.moveLength = "-".repeat(numOfMove);
    }
}
