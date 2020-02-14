package com.beemiel.monsterrace;

import java.util.Random;

public abstract class Monster {
    static final int RUN_NUMBER_OF_RUNNING = 4;
    static final int RUN_NUMBER_OF_FLYING = 6;
    static final int RUN_NUMBER_OF_ESPER = 9;

    private String name;
    private String type;
    protected int isRunNumber;
    protected String totalMove;
    protected Random random;
    protected StringBuffer stringBuffer;

    public Monster(String type, String name){
        this.name = name;
        this.type = type;
        this.random = new Random();
        this.totalMove = "";
    }

    public String getName() {
        return name;
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
