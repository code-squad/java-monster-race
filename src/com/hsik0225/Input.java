package com.hsik0225;

import java.util.Scanner;

public class Input {
    public int digit() {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        while (!inputLine.matches("[\\d]*") || inputLine.equals("")) {
            System.out.println("숫자를 입력해주세요");
            inputLine = scanner.nextLine();
        }
        return Integer.parseInt(inputLine);
    }
}
