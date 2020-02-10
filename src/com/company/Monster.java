package com.company;

import java.util.ArrayList;

public abstract class Monster  {
    String stepCount;
    String name;
    String attribute;

    Monster(ArrayList monsterInformation, int each) {
        int name = each * 2;
        int attribute = each * 2 + 1;
        this.name = (String) monsterInformation.get(name);
        this.attribute = (String) monsterInformation.get(attribute);
    }

    public abstract void runMonster(int attemptCount);
}