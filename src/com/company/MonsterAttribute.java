package com.company;

import java.util.Random;

enum MonsterAttribute {
    달리기 {
        public int countMonsterStep(Random random) {
            return random.nextInt(10) >= 4 ? 1 : 0;
        }
    }, 비행 {
        public int countMonsterStep(Random random) {
            return random.nextInt(10) >= 6 ? 3 : 0;
        }
    }, 에스퍼 {
        public int countMonsterStep(Random random) {
            return random.nextInt(10) == 9 ? random.nextInt(99) + 1 : 0;
        }
    };

    abstract int countMonsterStep(Random random);
}
