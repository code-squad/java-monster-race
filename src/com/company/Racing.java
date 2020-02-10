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
            //속성 체크 해서 new Esper 같이 넣어 생성?
            int monsterAttribute = each * 2 + 1;
            switch (Attribute.valueOf(monsterinformation.get(monsterAttribute))){
                case 달리기:
                    this.monsters[each] = new Run(monsterinformation, each);
                    break;
                case 비행:
                    this.monsters[each] = new Fly(monsterinformation, each);
                    break;
                case 에스퍼:
                    this.monsters[each] = new Esper(monsterinformation, each);
                    break;
            }
        }
    }

    public void runRacing() {
        IntStream.range(0, monsters.length).forEach(each -> monsters[each].runMonster(this.attemptCount));
    }

    public Monster[] endRacing() {
        return monsters;
    }
}
