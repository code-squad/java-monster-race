package com.hsik0225;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Monster {
    private String numOfMoved;

    public String getMoveLength() {
        return numOfMoved;
    }

    public String move(int numOfMove) {
        return "-".repeat(numOfMove);
    }
}