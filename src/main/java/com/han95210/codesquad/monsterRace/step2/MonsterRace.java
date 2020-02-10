package com.han95210.codesquad.monsterRace.step2;

import java.util.Scanner;

public class MonsterRace {

    private Scanner scanner;

    private int getNumberOfMonster() {
        scanner = new Scanner(System.in);

        // 몬스터 수 정하기
        System.out.println("몬스터는 모두 몇 마리인가요?");
        return scanner.nextInt();
    }

    // 기능 1개 : 시도할 횟수 입력 받기
    private int getNumberAttempts() {
        scanner = new Scanner(System.in);

        // 시도 횟수 정하기
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private static String getRandomDash() {
        String dashStr = "";
        int randomNum = (int) (Math.random() * 10);
        if (randomNum >= 4) {
            dashStr = "-";
        }
        return dashStr;
    }

    // 횟수가 주어졌을 때 랜덤으로 문자열에 -(dash)로 채워넣기
    private static String getDashStr(int numberAttempts) {
        StringBuilder dashStr = new StringBuilder();

        for (int i = 0; i < numberAttempts; i++) {
            dashStr.append(getRandomDash());
        }
        return dashStr.toString();
    }

    // 몬스터가 진행한 만큼 출력
    private void getForwardCount(int numberOfMonster, int numberAttempts) {
        for (int i = 0; i < numberOfMonster; i++) {
            System.out.println((i+1) + "번 몬스터 : " + getDashStr(numberAttempts));
        }
    }

    private void start() {
        MonsterRace monsterRace = new MonsterRace();

        System.out.println("<스릴만점 건전한 몬스터 경주>");

        int numberOfMonster = monsterRace.getNumberOfMonster();
        System.out.println(numberOfMonster);
        int numberAttempts = monsterRace.getNumberAttempts();
        System.out.println(numberAttempts);
        monsterRace.getForwardCount(numberOfMonster, numberAttempts);
    }

    public static void main(String[] args) {
        MonsterRace monsterRace = new MonsterRace();
        monsterRace.start();
    }
}
