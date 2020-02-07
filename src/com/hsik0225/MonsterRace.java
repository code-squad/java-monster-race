package com.hsik0225;

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

    private int makeRandomNumber(int bound){
        int randomValue = random.nextInt(bound);
        if(randomValue>=4){
            return randomValue;
        }
        return 0;
    }

    public void makeMonsters(){
        for (int index = 0; index < input.getMONSTER_COUNT(); index++) {
            monsters.add(new Monster());
        }
    }

    public void run() {
        for (int index = 0; index < input.getMONSTER_COUNT(); index++) {
            
        }
    }
}
