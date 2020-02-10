package com.hsik0225;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class MonsterRace {
    private Input input;
    private List<Monster> monsters;

    public MonsterRace() {
        input = new Input();
        monsters = new ArrayList<>();
    }

    public void startGame() {
        setGame();
        makeMonsters();
        startRace();
    }

    private void setGame() {
        System.out.println(OutputStrings.GAME_START);
        System.out.println(OutputStrings.MONSTER_COUNT_QUESTION);
        input.setMONSTER_COUNT();
        System.out.println(OutputStrings.ATTEMPT_COUNT_QUESTION);
        input.setCHALLENGE_COUNT();
    }

    private void makeMonsters() {
        for (int index = 0; index < input.getMONSTER_COUNT(); index++) {
            Monster monster = new Monster();
            monsters.add(monster);
        }
    }

    private void startRace() {
        System.out.println(OutputStrings.RACE_RESULT);
        for (int i = 0; i < input.getMONSTER_COUNT(); i++) {
            monsters.get(i).move(setNumOfMove(10, 4));
            String moveLength = monsters.get(i).getMoveLength();
            System.out.println(moveLength);
        }
        System.out.println(OutputStrings.GAME_EXIT);
    }

    private int setNumOfMove(int bound, int moveCondition) {
        Random random = new Random();
        return (int) IntStream.range(0, input.getCHALLENGE_COUNT())
                .map(index -> random.nextInt(bound))
                .filter(randomValue -> randomValue >= 4)
                .count();
    }
}