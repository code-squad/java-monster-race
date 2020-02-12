package com.hsik0225;

import java.util.ArrayList;
import java.util.List;

import static com.hsik0225.OutputStrings.*;

public class MonsterRace {
    private int monsterCount;
    private int attemptCount;
    private Input input;
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
            MonsterFactory monsterFactory = MonsterFactory.valueOf(monsterInfo[1]);
            monsterFactory.setName(monsterInfo[0]);
            Monster monster = null;
            monster =
            monsters.add(monster);
        }
    }

    private void startRace() {
        System.out.println(RACE_RESULT);
        for (Monster monster : monsters) {
            monster.setAttemptCount(attemptCount);
            monster.calcMoveCount();
            System.out.printf("%s [%s] : %s\n", monster.getName(), monster.getType(), monster.move());
        }
        System.out.printf(WINNER.toString(), checkWinner().toString());
        System.out.println(GAME_EXIT);
    }

    private List<String> checkWinner() {
        int maxMoveCount = 0;
        List<String> winners = new ArrayList<>();
        for (Monster monster : monsters) {
            int moveCount = monster.getMoveCount();
            if (moveCount > maxMoveCount) {
                maxMoveCount = moveCount;
                winners.clear();
            }
            if (moveCount >= maxMoveCount) {
                winners.add(monster.getName());
            }
        }
        return winners;
    }
}