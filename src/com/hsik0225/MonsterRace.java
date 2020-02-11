package com.hsik0225;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.hsik0225.OutputStrings.*;

public class MonsterRace {
    private Input input;
    private int monsterCount;
    private int attemptCount;
    private List<String[]> monstersInfo;
    private List<Monster> monsters;
    private HashMap<String, String> monsterTypeMap;

    public MonsterRace() {
        input = new Input();
        monsters = new ArrayList<>();
        monstersInfo = new ArrayList<>();
        monsterTypeMap = new HashMap<>();
    }

    public void startGame() {
        setGame();
        makeMonsterTypeMap();
        makeMonsters();
        startRace();
    }

    private void setGame() {
        System.out.println(GAME_START);

        System.out.println(MONSTER_COUNT_QUESTION);
        monsterCount = input.inputDigit();

        System.out.println(MONSTER_INFO_QUESTION);
        addMonstersInfo();

        System.out.println(ATTEMPT_COUNT_QUESTION);
        attemptCount = input.inputDigit();
    }

    private void addMonstersInfo() {
        for (int index = 0; index < monsterCount; index++) {
            String[] monsterInfo = input.inputMonstersInfo().replaceAll("\\s*", "").split(",");
            monstersInfo.add(monsterInfo);
        }
    }

    private void makeMonsterTypeMap(){
        monsterTypeMap.put("달리기", "RUNNER");
        monsterTypeMap.put("비행", "FLY");
        monsterTypeMap.put("에스퍼", "ESPER");
    }

    private void makeMonsters() {
        for (int index = 0; index < monsterCount; index++) {
            String name = monstersInfo.get(index)[0];
            String type = monstersInfo.get(index)[1];
            MonsterFactory monsterFactory = MonsterFactory.valueOf(monsterTypeMap.get(type));
            Monster monster = null;
            monster = monsterFactory.makeMonsterAsType(monster, name, type);
            monster.setAttemptCount(attemptCount);
            monsters.add(monster);
        }
    }

    private void startRace() {
        System.out.println(RACE_RESULT);
        for (int index = 0; index < monsterCount; index++) {
            Monster monster = monsters.get(index);
            monster.calcMoveCount();
            System.out.printf("%s [%s] : %s\n", monster.getName(), monster.getType(), monster.move());
        }
        System.out.printf(WINNER.toString(), checkWinner().toString());
        System.out.println(GAME_EXIT);
    }

    private int findMaxMoveCount() {
        return monsters.stream()
                .map(Monster::getMoveCount)
                .max(Integer::compareTo)
                .get();
    }

    private List<String> checkWinner() {
        List<String> winners = new ArrayList<>();
        int maxMoveCount = findMaxMoveCount();
        monsters.stream()
                .filter(monster -> monster.getMoveCount()==maxMoveCount)
                .forEach(monster -> winners.add(monster.getName()));

        return winners;
    }
}