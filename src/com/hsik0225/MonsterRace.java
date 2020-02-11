package com.hsik0225;

import java.util.ArrayList;
import java.util.List;

public class MonsterRace {
    private Input input;
    private int monsterCount;
    private int attemptCount;
    private List<Monster> monsters;

    public MonsterRace() {
        input = new Input();
        monsters = new ArrayList<>();
    }

    public void startGame() {
        setGame();
        startRace();
    }

    private void setGame() {
        System.out.println(OutputStrings.GAME_START);

        System.out.println(OutputStrings.MONSTER_COUNT_QUESTION);
        monsterCount = input.inputDigit();

        System.out.println(OutputStrings.MONSTER_INFO_QUESTION);
        makeMonsters();

        System.out.println(OutputStrings.ATTEMPT_COUNT_QUESTION);
        attemptCount = input.inputDigit();
    }

    private void makeMonsters() {
        String replaceRegex = "\\s*";
        String splitRegex = ",";
        for (int index = 0; index < monsterCount; index++) {
            String[] monsterInfo = input.inputMonstersInfo().replaceAll(replaceRegex, "").split(splitRegex);
            Monster monster;
            if (monsterInfo[1].equals("달리기")) {
                monster = new Runner(monsterInfo[0], monsterInfo[1]);
            } else if (monsterInfo[1].equals("비행")) {
                monster = new Fly(monsterInfo[0], monsterInfo[1]);
            } else {
                monster = new Esper(monsterInfo[0], monsterInfo[1]);
            }
            monsters.add(monster);
        }
    }

    private void startRace() {
        System.out.println(OutputStrings.RACE_RESULT);
        for (int i = 0; i < monsterCount; i++) {
            monsters.get(i).setAttemptCount(attemptCount);
            monsters.get(i).calcMoveCount();
            System.out.printf("%s [%s] : %s\n", monsters.get(i).getName()
                    , monsters.get(i).getType()
                    , monsters.get(i).move());
        }
        System.out.println(OutputStrings.GAME_EXIT);
    }
}