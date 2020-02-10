package com.hsik0225;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public int inputDigit() {
        String inputLine = scanner.nextLine();
        while (!inputLine.matches("[1-9][0-9]*")) {
            System.out.println(OutputStrings.INPUT_DIGIT);
            inputLine = scanner.nextLine();
        }
        return Integer.parseInt(inputLine);
    }

    public String inputMonstersInfo(){
        String inputLine = scanner.nextLine();
        while(!inputLine.matches(".*[,]\\s*(비행|에스퍼|달리기)\\s*")) {
            System.out.println("TRY AGAIN");
            inputLine = scanner.nextLine();
        }
        return inputLine;
    }
}