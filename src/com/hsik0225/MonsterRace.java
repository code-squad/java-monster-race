package com.hsik0225;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        addMonstersInfo();

        System.out.println(OutputStrings.ATTEMPT_COUNT_QUESTION);
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

    private void setMonsters() {
        for (int index = 0; index < monsterCount; index++) {
            String name = monstersInfo.get(index)[0];
            String type = monstersInfo.get(index)[1];
            MonsterType monsterType = MonsterType.valueOf(monsterTypeMap.get(type));
            monster.setAttemptCount(attemptCount);
            monsters.add(monster);
        }
    }

    private Monster makeMonster(Monster monster, String name, String type) {
        if (type.equals("달리기")) {
            monster = new Runner(name, type);
        } else if (type.equals("비행")) {
            monster = new Fly(name, type);
        }
        monster = new Esper(name, type);
        return monster;
    }

    private void startRace() {
        System.out.println(OutputStrings.RACE_RESULT);
        for (int index = 0; index < monsterCount; index++) {
            monsters.get(index).calcMoveCount();
            System.out.printf("%s [%s] : %s\n", monsters.get(index).getName()
                    , monsters.get(index).getType()
                    , monsters.get(index).move());
        }
        System.out.println(OutputStrings.CONGRATULATE + checkWinner().toString() + OutputStrings.VICTORY_MONSTER_RACE);
        System.out.println(OutputStrings.GAME_EXIT);
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
                .filter(monster -> monster.getMoveCount() == maxMoveCount)
                .forEach(monster -> winners.add(monster.getName()));

        return winners;
    }
}