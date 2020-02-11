package com.hsik0225;

public enum MonsterType {
    RUNNER{
        @Override
        void makeMonster(String name, String type) {
            Monster monster = new Runner(name, type);
        }
    },
    FLY {
        @Override
        void makeMonster(String name, String type) {
            Monster monster = new Fly(name, type);
        }
    },
    ESPER {
        @Override
        void makeMonster(String name, String type) {
            Monster monster = new Esper(name, type);
        }
    };

    abstract void makeMonster(String name, String type);
}
