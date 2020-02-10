package com.hsik0225;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    private String inputLine(String regex, OutputStrings outputString){
        String inputLine = scanner.nextLine();
        while (!inputLine.matches(regex)) {
            System.out.println(outputString);
            inputLine = scanner.nextLine();
        }
        return inputLine;
    }

    public int inputDigit() {
        String regex = "[1-9][0-9]*";
        OutputStrings outputString = OutputStrings.INPUT_DIGIT;
        String digit = inputLine(regex, outputString);
        return Integer.parseInt(digit);
    }

    public String inputMonstersInfo(){
        String regex = ".*[,]\\s*(비행|에스퍼|달리기)\\s*";
        OutputStrings outputString = OutputStrings.INPUT_TYPE;
        return inputLine(regex, outputString);
    }
}