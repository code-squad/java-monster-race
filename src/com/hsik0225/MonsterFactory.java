package com.hsik0225;

public enum MonsterFactory {
    달리기(new Runner()),
    비행 (new Fly()),
    에스퍼 (new Esper());

    private Movable movable;

    MonsterFactory(Movable movable) {
        this.movable = movable;
    }

    public Movable getMovable() {
        return movable;
    }
}
