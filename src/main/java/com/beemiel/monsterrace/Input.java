package com.beemiel.monsterrace;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    private Output output = new Output();

    public int inputMonster(){
        output.gameStart();
        output.getMonster();
        return scanner.nextInt();
    }

    public int inputCount(){
        output.getTry();
        return scanner.nextInt();
    }

    public void close(){
        scanner.close();
    }

}
