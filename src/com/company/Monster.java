package com.company;

import java.util.Random;

public class Monster {
    int stepCount;
    int attemptCount;

    Monster(int attemptCount){
        this.attemptCount = attemptCount;
    }

    public int[] runRacing(int monsterCount, int attemptCount) {
        int[] monsterStep = new int[monsterCount];
        for (int count = 0; count < monsterCount; count++) {
            monsterStep[count] = runMonster(attemptCount);
        }
        return monsterStep;
    }

    public int runMonster(int attemptCount) {
        this.stepCount = 0;
        Random random = new Random();

        for (int count = 0; count < attemptCount; count++) {
            this.stepCount += countMonsterStep(calculateMonsterStep(random.nextInt(10)));
        }
        return this.stepCount;
    }

    public boolean calculateMonsterStep(int randomNumber) {
        return randomNumber >= 4;
    }

    public int countMonsterStep(boolean checkStep) {
        return checkStep ? 1 : 0;
    }
}
