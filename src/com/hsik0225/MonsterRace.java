package com.hsik0225;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class MonsterRace {
    private Input input;
    private Output output;
    private List<Monster> monsters;

    public MonsterRace() {
        input = new Input();
        output = new Output();
        monsters = new ArrayList<>();
    }

    public void startGame() {
        setGame();
        makeMonsters();
        startRace();
    }

    private void setGame() {
        output.startMonsterRace();

        output.askMONSTERS_COUNT();
        input.setMONSTER_COUNT();

        output.askCHALLENGE_COUNT();
        input.setCHALLENGE_COUNT();
    }

    private void makeMonsters() {
        for (int index = 0; index < input.getMONSTER_COUNT(); index++) {
            Monster monster = new Monster();
            monsters.add(monster);
        }
    }

    private void startRace() {
        output.raceResult();
        for (int i = 0; i < input.getMONSTER_COUNT(); i++) {
            monsters.get(i).move(setNumOfMove(10, 4));
            String moveLength = monsters.get(i).getMoveLength();
            output.moveLength(moveLength);
        }
    }

    private int setNumOfMove(int bound, int moveCondition) {
        Random random = new Random();
        return (int) IntStream.range(0, input.getCHALLENGE_COUNT())
                .map(index -> random.nextInt(bound))
                .filter(randomValue -> randomValue >= 4)
                .count();
    }
}