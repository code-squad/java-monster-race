package com.company;

import java.util.Random;

public class Monster {
    String stepCount;

    public void runMonster(int attemptCount) {
        this.stepCount = "";
        Random random = new Random();

        for (int count = 0; count < attemptCount; count++) {
            this.stepCount += countMonsterStep(calculateMonsterStep(random.nextInt(10)));
        }
    }

    public boolean calculateMonsterStep(int randomNumber) {
        return randomNumber >= 4;
    }

    public String countMonsterStep(boolean checkStep) {
        return checkStep ? "-" : "";
    }
}