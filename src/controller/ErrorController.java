package controller;

import util.ErrorMessage;
import view.InputView;

import java.util.Arrays;

public class ErrorController {
    private final static String[] AVAILABLE_MONSTER_TYPE = {"달리기", "비행", "에스퍼"};

    private ErrorController(){}

    public static boolean verifyTypeOfMonster(String monsterType) {
        return Arrays.asList(AVAILABLE_MONSTER_TYPE).contains(monsterType);
    }

    public static boolean verifyInputFormat(String[] monster) {
        final int CORRECT_LENGTH = 2;
        return monster.length == CORRECT_LENGTH;
    }

    public static void printMonsterTypeErrorAndReInput() {
        System.out.println(ErrorMessage.monsterTypeError);
        reInput();
    }

    public static void printInputFormatErrorAndReInput() {
        System.out.println(ErrorMessage.inputFormatError);
        reInput();
    }

    private static void reInput() {
        InputView inputMonster = new InputView();
        inputMonster.initializeMonster();
    }
}
