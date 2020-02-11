package com.company;

public class Monster implements MoveInterface{
    int stepCount;
    String name;
    MonsterAttribute attribute;

    Monster(String monsterName, MonsterAttribute monsterAttribute) {
        this.name = monsterName;
        this.attribute = monsterAttribute;
    }

    @Override
    public void runMonster(int attemptCount) { }
}