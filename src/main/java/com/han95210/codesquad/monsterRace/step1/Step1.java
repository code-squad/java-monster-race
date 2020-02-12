package com.han95210.codesquad.monsterRace.step1;

import java.util.Scanner;

public class Step1 {

     //횟수가 주어졌을 때 랜덤으로 문자열에 -(dash)로 채워넣기
    String getForwardCount(int numberAttempts) {
        StringBuilder dashStr = new StringBuilder();

        for (int i = 0; i < numberAttempts; i++) {
            int randomNum = (int) (Math.random() * 10);
            if (randomNum >= 4) {
                dashStr.append("-");
            }
        }
        return dashStr.toString();
    }

    public static void main(String[] args) {
        Step1 step1 = new Step1();

        System.out.println("<스릴만점 건전한 몬스터 경주>");
        System.out.println("몬스터는 모두 몇 마리인가요?");
        Scanner scan = new Scanner(System.in);

        // 몬스터 수 정하기
        int numberOfMonster = scan.nextInt();
        System.out.println(numberOfMonster);

        // 시도 횟수 정하기
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numberAttempts = scan.nextInt();
        System.out.println(numberAttempts);

        // 이동 횟수 배열 만들기
        String[] forwardCount = new String[numberOfMonster];

        // 이동 횟수 배열에다가 getForwardCount 함수값 넣기
        for (int i = 0; i < forwardCount.length; i++) {
            forwardCount[i] = step1.getForwardCount(numberAttempts);
        }

        // forwardCount 배열의 각 원소 출력
        System.out.println("<실행 결과>");
        for(int i = 0; i < numberOfMonster; i++) {
            System.out.println((i+1) + "번 몬스터 " + forwardCount[i]);
        }
    }
}
