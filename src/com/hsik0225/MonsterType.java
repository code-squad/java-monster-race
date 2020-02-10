package com.hsik0225;

public enum MonsterType {
    int value;
    private MonsterType(int value){
        this.value = value;
    }
    Runner(0) {
        @Override
        public int move(Monster monster, int attemptCount) {
            int bound = 10;
            int moveCondition = 4;
            int numOfMoves = (int) monster.makeRandomValues(attemptCount, bound, moveCondition).count();
            return numOfMoves;
        }
    },
    Flight(1) {
        @Override
        public int move(Monster monster, int attemptCount) {
            int bound = 10;
            int moveCondition = 6;
            int numOfMoves = (int) monster.makeRandomValues(attemptCount, bound, moveCondition).count() * 3;
            return numOfMoves;
        }
    },
    Esper(2) {
        @Override
        public int move(Monster monster, int attemptCount) {
            int bound = 10;
            int moveCondition = 9;
            int numOfMoves = (int) monster.makeRandomValues(attemptCount, bound, moveCondition)
                    .map(randomValue -> monster.random.nextInt(100) + 1)
                    .reduce(0, Integer::sum);
            return numOfMoves;
        }
    };

    public abstract int move(Monster monster, int attemptCount);
}
