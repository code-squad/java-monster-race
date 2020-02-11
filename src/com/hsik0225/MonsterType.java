package com.hsik0225;

public enum MonsterType {
    RUNNER{
        @Override
        Monster makeMonsterAsType(Monster monster, String name, String type) {
            return new Runner(name, type);
        }
    },
    FLY {
        @Override
        Monster makeMonsterAsType(Monster monster, String name, String type) {
            return new Fly(name, type);
        }
    },
    ESPER {
        @Override
        Monster makeMonsterAsType(Monster monster, String name, String type) {
            return new Esper(name, type);
        }
    };

    abstract Monster makeMonsterAsType(Monster monster, String name, String type);
}
