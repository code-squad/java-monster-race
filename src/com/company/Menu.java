package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Menu {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Menu() {
        System.out.println("<스릴만점 건전한 몬스터 경주>");
    }

    public int inputMonsterCount() throws IOException {
        try {
            System.out.println("몬스터는 모두 몇 마리인가요?");
            int monsterCount = Integer.parseInt(br.readLine());
            checkValidmonsterCount(monsterCount);
            return monsterCount;
        } catch (Exception e) {
            System.out.println("정수를 입력 해 주세요");
            return inputMonsterCount();
        }
    }

    public void checkValidmonsterCount(int monsterCount) throws NegativeNumberException {
        if (monsterCount < 0) {
            throw new NegativeNumberException();
        }
    }

    public ArrayList inputMonsterInformation(int monsterCount) throws IOException {
        System.out.println("경주할 몬스터 이름과 종류를 입력하세요 (쉼표(,)를 기준으로 구분).");
        ArrayList<String> monsterInformation = new ArrayList<>();
        try {
            for (int i = 0; i < monsterCount; i++) {
                String[] information = br.readLine().split(", ");
                checkValidMonsterInformation(information);
                monsterInformation.addAll(Arrays.asList(information));
            }
            return monsterInformation;
        } catch (Exception e) {
            System.out.println("이름과 종류의 형식이 잘 못 되었습니다.");
            return inputMonsterInformation(monsterCount);
        }
    }

    public void checkValidMonsterInformation(String[] information) {
        if (information.length < 2) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int inputAttemptCount() throws IOException {
        System.out.println("시도할 회수는 몇 회 인가요?");
        try {
            int attemptCount = Integer.parseInt(br.readLine());
            checkValidAttemptCount(attemptCount);
            return attemptCount;
        } catch (Exception e) {
            System.out.println("시도 횟수를 정수로 입력 해 주세요");
            return inputAttemptCount();
        }
    }

    public void checkValidAttemptCount(int attemptCount) throws NegativeNumberException {
        if (attemptCount <= 0) {
            throw new NegativeNumberException();
        }
    }

    public void showResult(Monster[] eachMonster) {
        System.out.println("경기결과");
        for (int i = 0; i < eachMonster.length; i++) {
            System.out.println(eachMonster[i].name + " [" + eachMonster[i].attribute + "] " + toString(eachMonster[i].stepCount));
        }
    }

    public String toString(int stepCount) {
        String step = "";
        for (int i = 0; i < stepCount; i++) {
            step += "-";
        }
        return step;
    }

    public void showWinner(Monster[] eachMonster) {
        System.out.println();
        int[] rank = new int[eachMonster.length];
        initializeRank(rank);
        calculateRank(rank, eachMonster);
        for (int i = 0; i < rank.length; i++) {
            if (rank[i] == 1) {
                System.out.println("축하합니다! " + eachMonster[i].name + "가 몬스터 레이스에서 우승했습니다.");
            }
        }
    }

    public void initializeRank(int[] rank) {
        Arrays.fill(rank, 1);
    }

    public void calculateRank(int[] rank, Monster[] eachMonster) {
        for (int i = 0; i < eachMonster.length; i++) {
            for (int j = 0; j < eachMonster.length; j++) {
                if (eachMonster[i].stepCount < eachMonster[j].stepCount) {
                    rank[i]++;
                }
            }
        }
    }

    class NegativeNumberException extends Exception {
    }
}