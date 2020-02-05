package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.startRacing();
        int monsterCount = m.inputMonsterCount();
        int attemptCount = m.inputAttemptCount();
        int[] result = m.runRacing(monsterCount, attemptCount);
        m.showResult(result);
    }

    public void startRacing() {
        System.out.println("<스릴만점 건전한 몬스터 경주>");
    }

    public int inputMonsterCount() throws IOException {
        System.out.println("몬스터는 모두 몇 마리인가요?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    public int inputAttemptCount() throws IOException {
        System.out.println("시도할 회수는 몇 회 인가요?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    public int[] runRacing(int monsterCount, int attemptCount) {
        int[] monsterStep = new int[monsterCount];
        for (int count = 0; count < monsterCount; count++) {
            monsterStep[count] = runMonster(attemptCount);
        }
        return monsterStep;
    }

    public int runMonster(int attemptCount) {
        int stepCount = 0;
        Random random = new Random();

        for (int count = 0; count < attemptCount; count++) {
            stepCount += countMonsterStep(calculateMonsterStep(random.nextInt(10)));
        }
        return stepCount;
    }

    public boolean calculateMonsterStep(int randomNumber) {
        return randomNumber >= 4;
    }

    public int countMonsterStep(boolean checkStep) {
        return checkStep ? 1 : 0;
    }

    public void showResult(int[] result) {
        System.out.println("실행결과");
        Arrays.stream(result).forEach(value -> {
            for (int i = 0; i < value; i++) {
                String s = "-";
                System.out.print(s);
            }
            System.out.println();
        });
    }
}
