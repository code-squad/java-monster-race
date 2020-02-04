package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();
        int monsterCount = menu.inputMonsterCount();
        int attemptCount = menu.inputAttemptCount();

        Racing racing = new Racing();
        racing.setMonsterCount(monsterCount);
        racing.setAttemptCount(attemptCount);
        racing.createMonster();
        racing.runRacing();
        menu.showResult(racing.endRacing());
    }
}
