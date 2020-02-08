package dev.solar;

import java.util.Scanner;

public class InputHandler {
    Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputProperType(String promptMessage) {
        try {
            System.out.println(promptMessage);
            int inputValue = Integer.parseInt(scanner.nextLine());

            if(inputValue < 0) {
                System.out.println("음수는 입력하실 수 없습니다. 다시 입력해주세요.");
                return inputProperType(promptMessage);
            }
            return inputValue;
        } catch (NumberFormatException e) {
            System.out.println("숫자 값만 입력하실 수 있습니다. 다시 입력해주세요.");
            return inputProperType(promptMessage);
        }
    }
}
