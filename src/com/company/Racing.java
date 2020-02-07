package com.company;

import java.util.ArrayList;

public class Racing {
    Monster[] monsters;
    int monsterCount;
    int attemptCount;

    Racing(int monsterCount, int attemptCount){
        this.monsterCount = monsterCount;
        this.attemptCount = attemptCount;
    }

    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }

    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public void createMonster(ArrayList<String> monsterinformation) {
        monsters = new Monster[this.monsterCount];
        for (int size = 0; size < this.monsterCount; size++) {
            this.monsters[size] = new Monster();
        }
    }

    public void runRacing() {
        for (int number = 0; number < monsters.length; number++) {
            monsters[number].runMonster(this.attemptCount);
        }
    }

    public String[] endRacing() {
        String[] result = new String[this.monsters.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = String.valueOf(this.monsters[i].stepCount);
        }
        return result;
    }
}
