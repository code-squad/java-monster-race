package com.hsik0225;

public enum MonsterFactory {
    달리기{
        @Override
        Monster makeMonster() {
            return new Monster(4,1);
        }
    },
    비행 {
        @Override
        Monster makeMonster() {
            return new Monster(6,3);
        }
    },
    에스퍼 {
        @Override
        Monster makeMonster() {
            return new Monster(9, (int)(Math.random()*100)+1);
        }
    };

    abstract Monster makeMonster();
}
