package com.hsik0225;

import java.util.Scanner;

public class MonsterRace {
    public MonsterRace(){

    }

    public void setGame(){
        final int MONSTER_COUNT = input("몬스터는 모두 몇 마리인가요?");
        final int CHALLENGE_COUNT = input("시도할 회수는 몇 회 인가요?");
    }

    public int input(String question){
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        String inputLine = scanner.nextLine();
        while(!inputLine.matches("[\\d]*")){
            System.out.println("숫자를 입력해주세요");
            inputLine = scanner.nextLine();
        }
        return Integer.parseInt(inputLine);
    }

    public void startGame(){

    }
}
