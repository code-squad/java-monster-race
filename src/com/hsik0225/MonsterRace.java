package com.hsik0225;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

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

    public void move(int CHALLENGE_COUNT){
        Random random = new Random();
        IntStream.range(0, CHALLENGE_COUNT)
                .map(count -> random.nextInt(10))
                .filter(randomValue -> randomValue >= 4)
                .forEach(randomValue -> {
                    moveAppend();
                });
    }

    public void moveAppend(){

    }

    public void startGame(){
        System.out.println("<실행 결과>");
    }
}
