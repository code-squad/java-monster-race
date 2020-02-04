package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();
        int monsterCount = menu.inputMonsterCount();
        int attemptCount = menu.inputAttemptCount();

        //다음 단계에 Racing 클래스에서 몬스터를 만들고 경기 진행
        Monster monster = new Monster(attemptCount);
        int[] result = monster.runRacing(monsterCount, attemptCount);
        menu.showResult(result);
    }
}
