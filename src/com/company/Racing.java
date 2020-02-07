package com.company;

import java.util.ArrayList;

public class Racing {
    Monster[] monsters;
    int monsterCount;
    int attemptCount;

    Racing(int monsterCount, int attemptCount) {
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
        for (int each = 0; each < this.monsterCount; each++) {
            this.monsters[each] = new Monster(monsterinformation, each);
        }
    }

    public void runRacing() {
        for (int number = 0; number < monsters.length; number++) {
            monsters[number].runMonster(this.attemptCount);
        }
    }

    public Monster[] endRacing() {
        return monsters;
    }
}
