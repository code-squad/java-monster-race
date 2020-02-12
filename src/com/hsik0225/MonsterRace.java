package com.hsik0225;

import java.util.ArrayList;
import java.util.List;

import static com.hsik0225.OutputStrings.ATTEMPT_COUNT_QUESTION;
import static com.hsik0225.OutputStrings.GAME_EXIT;
import static com.hsik0225.OutputStrings.GAME_START;
import static com.hsik0225.OutputStrings.MONSTER_COUNT_QUESTION;
import static com.hsik0225.OutputStrings.MONSTER_INFO_AND_DISTANCE;
import static com.hsik0225.OutputStrings.MONSTER_INFO_QUESTION;
import static com.hsik0225.OutputStrings.RACE_RESULT;
import static com.hsik0225.OutputStrings.WINNER;

public class MonsterRace {
    private int monsterCount;
    private int attemptCount;
    private Input input;
    private List<Monster> monsters;

    public MonsterRace() {
        input = new Input();
        monsters = new ArrayList<>();
    }

    public void run() {
        setGame();
        race();
        showRaceResult();
        showWinner();
        exitGame();
    }

    private void setGame() {
        System.out.println(GAME_START);

        System.out.println(MONSTER_COUNT_QUESTION);
        monsterCount = input.inputDigit();

        System.out.println(MONSTER_INFO_QUESTION);
        makeMonsters();

        System.out.println(ATTEMPT_COUNT_QUESTION);
        attemptCount = input.inputDigit();
    }

    private void makeMonsters() {
        for (int index = 0; index < monsterCount; index++) {
            String[] monsterInfo = input.inputMonstersInfo().replaceAll("\\s*", "").split(",");
            String name = monsterInfo[0];
            String type = monsterInfo[1];
            Monster monster = MonsterFactory.valueOf(type).makeMonster();
            monster.setName(name);
            monster.setType(type);
            monsters.add(monster);
        }
    }

    private void race() {
        for (Monster monster : monsters) {
            monster.giveRandomValues(attemptCount);
        }
    }

    private void showRaceResult(){
        System.out.println(RACE_RESULT);
        for (Monster monster : monsters) {
            System.out.printf(MONSTER_INFO_AND_DISTANCE.toString(), monster.getName()
                    , monster.getType()
                    , monster.move());
        }
    }

    private void showWinner() {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();
        for (Monster monster : monsters) {
            int distance = monster.getDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
            }
            if (distance >= maxDistance) {
                winners.add(monster.getName());
            }
        }
        System.out.printf(WINNER.toString(), winners.toString());
    }

    private void exitGame(){
        System.out.println(GAME_EXIT);
    }
}