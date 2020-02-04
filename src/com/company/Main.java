package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        Main m = new Main();

        Menu menu = new Menu();
        int monsterCount = menu.inputMonsterCount();
        int attemptCount = menu.inputAttemptCount();
        int[] result = m.runRacing(monsterCount, attemptCount);
        m.showResult(result);
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
