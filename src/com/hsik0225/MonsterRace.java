package com.hsik0225;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MonsterRace {
    int MONSTER_COUNT;
    int CHALLENGE_COUNT;

    public MonsterRace(){
        setGame();
        startGame();
    }

    public void setGame(){
        MONSTER_COUNT = input("몬스터는 모두 몇 마리인가요?");
        CHALLENGE_COUNT = input("시도할 회수는 몇 회 인가요?");
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

    public String move(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, CHALLENGE_COUNT)
                .map(count -> random.nextInt(10))
                .filter(randomValue -> randomValue >= 4)
                .forEach(randomValue -> {
                    moveAppend(stringBuilder, randomValue);
                });
        return stringBuilder.toString();
    }

    public void moveAppend(StringBuilder stringBuilder, int randomValue){
        IntStream.range(0, randomValue).forEach(count -> stringBuilder.append("-"));
    }

    public void startGame(){
        System.out.println("<실행 결과>");
        IntStream.range(0, MONSTER_COUNT)
                .forEach(count -> System.out.println(move()));
    }
}
