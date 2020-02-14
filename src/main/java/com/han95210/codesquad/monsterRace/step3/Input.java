package com.han95210.codesquad.monsterRace.step3;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    private Scanner scanner;
    public int NumberOfMonster;
    private int NumberOfAttempts;
    private String[] monstersNameAndSpecies;

    public Input() {
        scanner = new Scanner(System.in);
        NumberOfMonster = inputNumberOfMonster();
        monstersNameAndSpecies = inputMonsterNameAndSpecies(NumberOfMonster);
        NumberOfAttempts = inputNumberOfAttempts();
        scanner.close();
    }

    // 몬스터 수 정하기
    private int inputNumberOfMonster() {
        System.out.println("몇 마리의 몬스터가 경주하나요?");
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("잘못 입력했습니다. 숫자만 입력해주세요.");
            }
        }
    }

    // 경주할 몬스터 이름과 종류를 입력받기
    private String[] inputMonsterNameAndSpecies(int numberOfMonster) {
        String[] monstersInfo = new String[numberOfMonster];
        System.out.println("경주할 몬스터 이름과 종류를 입력하세요(쉼표(,)를 기준으로 구분).");
        for (int i = 0; i < numberOfMonster; i++) {
            monstersInfo[i] = scanner.nextLine();
            if (!monstersInfo[i].contains(",")) {
                System.out.println("잘못 입력했습니다.");
                System.out.println("경주할 몬스터 이름과 종류를 입력하세요(쉼표(,)를 기준으로 구분).");
                i--;
            }
        }
        return monstersInfo;
    }

    // 시도할 횟수 정하기
    private int inputNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("잘못 입력했습니다. 숫자만 입력해주세요.");
            }
        }
    }

    public static void main(String[] args) {
        Input ip = new Input();
        System.out.println(ip.NumberOfMonster);
        System.out.println(ip.NumberOfAttempts);
        System.out.println(Arrays.toString(ip.monstersNameAndSpecies));
    }
}
