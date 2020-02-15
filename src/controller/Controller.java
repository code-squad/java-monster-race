package controller;

import model.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    public static ArrayList<Monster> monsterList = new ArrayList<>();
    public static int numberOfMonster;
    public static int chance;

    private Controller() {}

    public static void race() {
        for (int i = 0; i < chance; i++) {
            monsterList.forEach(Monster::move);
        }
    }

    public static void setMonsterList(String[] monster){
        if (ErrorController.verifyInputFormat(monster)) {
            final String NAME = monster[0];
            final String TYPE = monster[1];

            if (ErrorController.verifyTypeOfMonster(TYPE)) {
                createMonster(NAME, TYPE);
                return;
            }
            ErrorController.printMonsterTypeErrorAndReInput();
            return;
        }
        ErrorController.printInputFormatErrorAndReInput();
    }

    private static void createMonster(String monsterName, String monsterType) {
        if (monsterType.equals("달리기")) {
            monsterList.add(new RunTypeMonster(monsterName));
        } else if (monsterType.equals("비행")) {
            monsterList.add(new FlyTypeMonster(monsterName));
        } else {
            monsterList.add(new EsperTypeMonster(monsterName));
        }
    }
}
