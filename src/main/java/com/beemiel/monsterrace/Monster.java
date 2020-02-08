package com.beemiel.monsterrace;

import java.util.Random;

public abstract class Monster {
    private String name;
    private String type;
    protected String totalMove;
    protected Random random;
    protected StringBuffer stringBuffer;

    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
        this.random = new Random();
        this.totalMove = "";
    }

    public String getName() {
        return name;
    }

    /* 랜덤값을 받아서 각자의 조건에 맞는 값이면 true를 반환 */
    abstract public boolean isMove();

    /* isMove()가 true이면 원하는 타입마다 이동 */
    abstract public void moveOrStop();

    public void run(int count){
        for(int i=0; i<count; i++){
            moveOrStop();
        }
    }

    @Override
    public String toString() {
        return name + "[" + type + "]" + " : " + totalMove;
    }
}
