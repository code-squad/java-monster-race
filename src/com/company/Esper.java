package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Esper extends Monster implements MoveInterface{
    Esper(ArrayList monsterInformation, int each) {
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
        return randomNumber == 9;
    }

    @Override
    public String countMonsterStep(boolean checkStep) {
        String step = "";
        if (!checkStep) {
            return step;
        }
        Random random = new Random();
        int rand = random.nextInt(100) + 1;
        for (int i = 0; i < rand; i++) {
            step += "-";
        }
        return step;
    }
}
