package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Monster {
    String stepCount;
    String name;
    String attribute;

    Monster(ArrayList monsterInformation, int each) {
        int name = each * 2;
        int attribute = each * 2 + 1;
        this.name = (String) monsterInformation.get(name);
        this.attribute = (String) monsterInformation.get(attribute);
    }

    public void runMonster(int attemptCount) {
        this.stepCount = "";
        Random random = new Random();

        for (int count = 0; count < attemptCount; count++) {
            this.stepCount += countMonsterStep(judgeRandomNumber(random.nextInt(10)));
        }
    }

    public boolean judgeRandomNumber(int randomNumber) {
        return randomNumber >= 4;
    }

    public String countMonsterStep(boolean checkStep) {
        return checkStep ? "-" : "";
    }
}