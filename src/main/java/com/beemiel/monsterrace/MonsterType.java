package com.beemiel.monsterrace;

public enum MonsterType {
    FLY(new Flying("비행")), RUN(new Running("달리기")), ESPER(new Psychic("에스퍼"));

    //연관된 데이터
    Monster monster;

    MonsterType(Monster monster) {
        this.monster = monster;
    }

    public Monster getMonster(){
        return monster;
    }
}
