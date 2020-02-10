package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Fly extends Monster implements MoveInterface {
    Fly(ArrayList monsterInformation, int each) {
        super(monsterInformation, each);
    }

    @Override
    public void runMonster(int attemptCount) {
        this.stepCount = "";
        Random random = new Random();

        for (int count = 0; count < attemptCount; count++) {
            this.stepCount += countMonsterStep(judgeRandomNumber(random.nextInt(10)));
        }
    }

    @Override
    public boolean judgeRandomNumber(int randomNumber) {
        return randomNumber >= 6;
    }

    @Override
    public String countMonsterStep(boolean checkStep) {
        return checkStep ? "---" : "";
    }
}
