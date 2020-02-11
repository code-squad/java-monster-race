package com.hsik0225;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private static final Pattern DIGIT_PATTERN = Pattern.compile("^[1-9][0-9]*$");
    private static final Pattern MONSTER_INFO_PATTERN = Pattern.compile(".*([,])\\s*(비행|에스퍼|달리기)\\s*");
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    private String inputLine(Pattern pattern, OutputStrings outputString) {
        String inputLine = scanner.nextLine();
        Matcher matcher = pattern.matcher(inputLine);
        while (!matcher.matches()) {
            System.out.println(outputString);
            inputLine = scanner.nextLine();
            matcher = pattern.matcher(inputLine);
        }
        return inputLine;
    }

    public int inputDigit() {
        String digit = inputLine(DIGIT_PATTERN, OutputStrings.INPUT_DIGIT);
        return Integer.parseInt(digit);
    }

    public String inputMonstersInfo() {
        return inputLine(MONSTER_INFO_PATTERN, OutputStrings.INPUT_TYPE);
    }
}