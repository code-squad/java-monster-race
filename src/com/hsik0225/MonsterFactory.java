package com.hsik0225;

public enum MonsterFactory {
    달리기(new Monster(4, 1)),
    비행(new Monster(6, 3)),
    에스퍼(new Monster(9, (int)(Math.random()*100)+1));

    private Monster monster;

    MonsterFactory(Monster monster) {
        this.monster = monster;
    }

    public Monster makeMonster(String name, String type){
        monster.setName(name);
        monster.setType(type);
        return monster;
    }
}
