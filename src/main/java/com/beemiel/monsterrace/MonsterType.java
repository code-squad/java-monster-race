package com.beemiel.monsterrace;

public enum MonsterType {
    Fly(new Flying("비행")), Run(new Running("달리기")), Esper(new Psychic("에스퍼"));

    //연관된 데이터
    Monster monster;

    MonsterType(Monster monster) {
        this.monster = monster;
    }

    public Monster getMonster(){
        return monster;
    }
}
