package com.han95210.codesquad.monsterRace.step2;

import java.util.Scanner;

public class MonsterRace {

    private Scanner scanner;

    private int getNumberOfMonster() {
        scanner = new Scanner(System.in);
        System.out.println("<스릴만점 건전한 몬스터 경주>");
        System.out.println("몬스터는 모두 몇 마리인가요?");

        // 몬스터 수 정하기
        int numberOfMonster = scanner.nextInt();
        return numberOfMonster;
    }

    private int getNumberAttempts() {
        scanner = new Scanner(System.in);
        // 시도 횟수 정하기
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numberAttempts = scanner.nextInt();
        return numberAttempts;
    }

    // 횟수가 주어졌을 때 랜덤으로 문자열에 -(dash)로 채워넣기
    public static String getString(int numberAttempts) {
        StringBuilder dashStr = new StringBuilder();

        for (int i = 0; i < numberAttempts; i++) {
            int randomNum = (int) (Math.random() * 10);
            if (randomNum >= 4) {
                dashStr.append("-");
            }
        }
        return dashStr.toString();
    }

    // 몬스터가 진행한 만큼 출력
    private void getForwardCount(int numberOfMonster, int numberAttempts) {
        for (int i = 0; i < numberOfMonster; i++) {
            System.out.println((i+1) + "번 몬스터 : " + getString(numberAttempts));
        }
    }

    private void start() {
        MonsterRace monsterRace = new MonsterRace();

        int numberOfMonset = monsterRace.getNumberOfMonster();
        System.out.println(numberOfMonset);
        int numberAttempts = monsterRace.getNumberAttempts();
        System.out.println(numberAttempts);
        monsterRace.getForwardCount(numberOfMonset, numberAttempts);
    }

    public static void main(String[] args) {
        MonsterRace monsterRace = new MonsterRace();
        monsterRace.start();
    }
}
