package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Menu {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Menu() {
        System.out.println("<스릴만점 건전한 몬스터 경주>");
    }

    public int inputMonsterCount() throws IOException {
        System.out.println("몬스터는 모두 몇 마리인가요?");
        int monsterCount = Integer.parseInt(br.readLine());
        return monsterCount;
    }

    public ArrayList inputMonsterInformation(int monsterCount) throws IOException {
        System.out.println("경주할 몬스터 이름과 종류를 입력하세요 (쉼표(,)를 기준으로 구분).");
        ArrayList<String> monsterInformation = new ArrayList<>();
        for (int i = 0; i < monsterCount; i++) {
            String[] information = br.readLine().split(", ");
            monsterInformation.addAll(Arrays.asList(information));
        }
        return monsterInformation;
    }

    public int inputAttemptCount() throws IOException {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int attemptCount = Integer.parseInt(br.readLine());
        return attemptCount;
    }

    public void showResult(Monster[] eachMonster) {
        System.out.println("경기결과");
        for (int i = 0; i < eachMonster.length; i++) {
            System.out.println(eachMonster[i].name + " [" + eachMonster[i].attribute + "] " + eachMonster[i].stepCount);
        }
    }
}
