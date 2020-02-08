package com.beemiel.monsterrace;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    private Message message = new Message();

    public int inputMonster(){
        message.gameTitle();
        message.getMonster();
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] inputMonsterInfo(){
        return scanner.nextLine().split(",");
    }

    public int inputCount(){
        message.getTry();
        return scanner.nextInt();
    }

    public void close(){
        scanner.close();
    }

}
