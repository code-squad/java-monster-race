package com.beemiel.monsterrace;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    private Message message = new Message();

    public int inputMonster() throws NumberFormatException{
        message.gameTitle();
        message.getMonster();
        return Integer.parseInt(scanner.nextLine());
    }

    public Monster inputMonsterInfo() {
        String[] info;

        while(true){
            try{
                info = scanner.nextLine().split(",");
                String type = info[1];
                String name = info[0];
                MonsterType monsterType = MonsterType.valueOf(type);
                monsterType.getMonster().setName(name);
                return monsterType.getMonster();
            } catch (Exception e){
                e.getMessage();
                System.out.println("제대로 된 타입을 입력하세요");
            }
        }
    }

    public int inputCount() throws InputMismatchException {
        message.getTry();
        return scanner.nextInt();
    }

    public void close(){
        scanner.close();
    }

}
