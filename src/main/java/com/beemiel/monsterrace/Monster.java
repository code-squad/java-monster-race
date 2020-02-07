package com.beemiel.monsterrace;

import javax.swing.*;
import java.util.Random;

public abstract class Monster {
    private String name;
    private String type;
    protected String totalMove;
    protected Random random;
    protected StringBuffer stringBuffer = new StringBuffer();

    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
        this.random = new Random();
    }

//    public int canMove(){
//        return random.nextInt(10);
//    }

    abstract public boolean isMove();
//    {
////        Random random = new Random();
//        return random.nextInt(10) > 4;
//    }

    abstract public void moveOrStop();
//    public void moveOrStop() {
//        if (isMove()){
//            Message.printRun();
//        }
//    }


//            for(int i=0; i<count; i++){
//        moveOrStop();
//    }

    public void run(int count){
        for(int i=0; i<count; i++){
            moveOrStop();
        }
    }
//    abstract public void run(int count);
//    {
//        while (count > 0) {
//            runOrStop();
//            count--;
//        }
//        Message.next();
//    }

    @Override
    public String toString() {
        return name + "[" + type + "]" + " : " + totalMove;
    }
}
