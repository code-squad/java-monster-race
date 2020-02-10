package com.hsik0225;

import java.util.Scanner;

public class Input {
    private int MONSTER_COUNT;
    private int CHALLENGE_COUNT;
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    private int inputDigit() {
        String inputLine = scanner.nextLine();
        while (!inputLine.matches("[1-9][0-9]*")) {
            System.out.println("1~9 사이의 숫자를 입력해주세요");
            inputLine = scanner.nextLine();
        }
        return Integer.parseInt(inputLine);
    }

    public int getMONSTER_COUNT() {
        return MONSTER_COUNT;
    }

    public void setMONSTER_COUNT() {
        this.MONSTER_COUNT = inputDigit();
    }

    public int getCHALLENGE_COUNT() {
        return CHALLENGE_COUNT;
    }

    public void setCHALLENGE_COUNT() {
        this.CHALLENGE_COUNT = inputDigit();
    }
}