package com.hsik0225;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MonsterRace {
    private Input input;
    private Output output;
    private Random random;
    private List<Monster> monsters;

    public MonsterRace(){
        input = new Input();
        output = new Output();
        random = new Random();
    }

    public void setGame(){
        output.startMonsterRace();

        output.askMONSTERS_COUNT();
        input.setMONSTER_COUNT();

        output.askCHALLENGE_COUNT();
        input.setCHALLENGE_COUNT();
    }

    private int setNumOfMove(int bound, int moveCondition){
        ArrayList<Integer> moveOK = new ArrayList<>();
        for (int index = 0; index < input.getCHALLENGE_COUNT(); index++) {
            int randomValue = random.nextInt(bound);
            if(randomValue>=moveCondition){
                moveOK.add(randomValue);
            }
        }
        return moveOK.size();
    }

    public void makeMonsters(){
        for (int index = 0; index < input.getMONSTER_COUNT(); index++) {
            Monster monster = new Monster();
            monsters.add(monster);
        }
    }

    public void run() {
        output.raceResult();
        for (int i = 0; i < input.getMONSTER_COUNT(); i++) {
            monsters.get(i).move(setNumOfMove(10,4));
            String moveLength = monsters.get(i).getMoveLength();
            output.moveLength(moveLength);
        }
    }
}
