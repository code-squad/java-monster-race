package dev.solar;

import java.util.Scanner;

public class InputHandler {
    Scanner scanner = new Scanner(System.in);

    public Integer inputProperType(String promptMesssage) {
        try {
            System.out.println(promptMesssage);
            int inputValue = Integer.parseInt(scanner.nextLine());
            return inputValue;
        } catch (NumberFormatException e) {
            System.out.println("숫자 값만 입력하실 수 있습니다. 다시 입력해주세요.");
            return inputProperType(promptMesssage);
        }
    }
}
