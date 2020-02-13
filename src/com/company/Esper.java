package com.company;

import java.util.Random;

public class Esper extends Monster implements MoveInterface{
    Esper(String monsterName, MonsterAttribute monsterAttribute) {
        super(monsterName, monsterAttribute);
    }

    @Override
    public void runMonster(int attemptCount) {
        this.stepCount = 0;
        Random random = new Random();

        for (int count = 0; count < attemptCount; count++) {
            this.stepCount += this.attribute.countMonsterStep(random);
        }
    }
}
