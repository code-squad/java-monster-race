package com.beemiel.monsterrace;

import java.util.Random;

public abstract class Monster {
    private String name;
    private String type;
    protected int isRunNumber;
    protected String totalMove;
    protected Random random;
    protected StringBuffer stringBuffer;

    public Monster(String type, int isRunNumber){
        this.type = type;
        this.isRunNumber = isRunNumber;
        this.random = new Random();
        this.totalMove = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMove(){
        return random.nextInt(10) >= this.isRunNumber;
    }

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
