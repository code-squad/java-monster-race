package dev.idion.monsterrace.io;

import dev.idion.monsterrace.MainMenu;
import dev.idion.monsterrace.StringConstants;
import dev.idion.monsterrace.monster.Monster;
import dev.idion.monsterrace.monster.MonsterManagerMenu;
import dev.idion.monsterrace.monster.MonsterType;

import java.util.Arrays;
import java.util.Scanner;

import static dev.idion.monsterrace.StringConstants.*;

public class Input {
    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public int selectMenu(StringConstants constants) {
        System.out.println(constants);
        printMenus(constants);
        System.out.print(PROMPT);
        return inputPositiveValue(MENU_NUMBER);
    }

    private void printMenus(StringConstants constants) {
        switch (constants) {
            case PLEASE_SELECT_MENUS_MAIN:
                Arrays.stream(MainMenu.values()).forEach(System.out::println);
                break;
            case PLEASE_SELECT_MENUS_MONSTER:
                Arrays.stream(MonsterManagerMenu.values()).forEach(System.out::println);
                break;
            default:
                // TODO: default에서 무엇을 해주어야 할까?
        }
    }

    public int inputPositiveValue(StringConstants menuNumber) {
        System.out.println(menuNumber + INPUT_MESSAGE.toString());
        System.out.print(PROMPT);
        while (true) {
            try {
                return getCheckedIntegerValue(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.printf(CORRECT_INPUT_STRING.toString(),
                        menuNumber,
                        e.getMessage(),
                        PROMPT);
            }
        }
    }

    private int getCheckedIntegerValue(String input) {
        int integer = Integer.parseInt(input);
        if (integer < 1) {
            throw new NumberFormatException(THE_NUMBER_MUST_BE_POSITIVE_VALUE.toString());
        }
        return integer;
    }

    public Monster inputMonsterInfo() {
        System.out.print(PROMPT);
        String[] inputs = scanner.nextLine().split(",");
        if (inputs.length < 2) {
            throw new ArrayIndexOutOfBoundsException(INPUT_CORRECT_MONSTER_NAME_AND_TYPE.toString());
        }
        String monsterName = inputs[0].trim();
        MonsterType monsterType = MonsterType.valueOfKoreanType(inputs[1].trim());
        return new Monster(monsterName, monsterType);
    }

    public void close() {
        scanner.close();
    }
}