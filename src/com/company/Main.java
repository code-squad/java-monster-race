package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();

        int monsterCount = menu.inputMonsterCount();
        ArrayList<String> monsterInformation = menu.inputMonsterInformation(monsterCount);
        int attemptCount = menu.inputAttemptCount();

        Racing racing = new Racing(monsterCount, attemptCount);
        racing.createMonster(monsterInformation);
        racing.runRacing();
        menu.showResult(racing.endRacing());
        menu.br.close();
    }
}
