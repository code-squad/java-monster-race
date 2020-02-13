package com.company;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Racing {
    Monster[] monsters;
    int monsterCount;
    int attemptCount;

    Racing(int monsterCount, int attemptCount) {
        this.monsterCount = monsterCount;
        this.attemptCount = attemptCount;
    }

    public void createMonster(ArrayList<String> monsterinformation) {
        monsters = new Monster[this.monsterCount];
        for (int each = 0; each < this.monsterCount; each++) {
            choiceMonsterAttribute(monsterinformation, each);
        }
    }

    public void choiceMonsterAttribute(ArrayList<String> monsterinformation, int each) {
        int monsterNameIndex = each * 2;
        int monsterAttributeIndex = each * 2 + 1;

        MonsterAttribute monsterType = MonsterAttribute.valueOf(monsterinformation.get(monsterAttributeIndex));
        switch (monsterType) {
            case 달리기:
                this.monsters[each] = new Run(monsterinformation.get(monsterNameIndex), monsterType);
                break;
            case 비행:
                this.monsters[each] = new Fly(monsterinformation.get(monsterNameIndex), monsterType);
                break;
            case 에스퍼:
                this.monsters[each] = new Esper(monsterinformation.get(monsterNameIndex), monsterType);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + MonsterAttribute.valueOf(monsterinformation.get(monsterAttributeIndex)));
        }
    }

    public void runRacing() {
        IntStream.range(0, monsters.length).forEach(each -> monsters[each].runMonster(this.attemptCount));
    }

    public Monster[] endRacing() {
        return monsters;
    }
}
