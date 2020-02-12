package com.hsik0225;

import java.util.Random;

public enum MonsterFactory {
    달리기(new Monster() {
        @Override
        public void calcMoveCount() {
            final int bound = 10;
            final int moveCondition = 4;
            moveCount =  (int)makeRandomValues(bound, moveCondition).count();
        }
    }),
    비행(new Monster() {
        @Override
        public void calcMoveCount() {
            final int bound = 10;
            final int moveCondition = 6;
            moveCount =  (int)makeRandomValues(bound, moveCondition).count() * 3;
        }
    }),
    에스퍼(new Monster() {
        @Override
        public void calcMoveCount() {
            final int bound = 10;
            final int moveCondition = 9;
            Random random = new Random();
            moveCount =  (int)makeRandomValues(bound, moveCondition).map(randomValue -> random.nextInt(100) + 1)
                    .reduce(0, Integer::sum);
        }
    });

    private Monster monster;

    MonsterFactory(Monster monster) {
        this.monster = monster;
    }

    public Monster makeMonster(){
        return monster;
    }
}
