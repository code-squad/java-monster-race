package com.beemiel.monsterrace;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    public String inputMonster() {
        return scanner.nextLine();
    }

    public String inputMonsterInfo(){
        return scanner.nextLine();
    }

    public String inputCount() {
        return scanner.nextLine();
    }

    public void close(){
        scanner.close();
    }

}
