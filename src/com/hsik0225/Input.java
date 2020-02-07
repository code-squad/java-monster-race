package com.hsik0225;

import java.util.Scanner;

public class Input {
    public int input() {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        while (!inputLine.matches("[\\d]*") || inputLine.equals("")) {
            System.out.println("숫자를 입력해주세요");
            inputLine = scanner.nextLine();
        }
        return Integer.parseInt(inputLine);
    }

    public int getMONSTER_COUNT(int MONSTER_COUNT){
        return MONSTER_COUNT;
    }

    public int getCHALLENGE_COUNT(int CHALLENGE_COUNT){
        return CHALLENGE_COUNT;
    }
}
