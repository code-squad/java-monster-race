package com.beemiel.monsterrace;

public class Output {

    public void gameStart(){
        System.out.println(Message.START);
    }

    public void getMonster(){
        System.out.println(Message.MONSTER);
    }

    public void getTry(){
        System.out.println(Message.TRY);
    }

    public void result(){
        System.out.println(Message.RESULT);
    }

    public void gameClose(){
        System.out.println(Message.CLOSE);
    }

    public static void printRun(){
        System.out.print(Message.RUN);
    }

    public static void next(){
        System.out.println("");
    }
}
