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
    private int MONSTER_COUNT;
    private int CHALLENGE_COUNT;

    public MonsterRace(){
        input = new Input();
        output = new Output();
        random = new Random();
    }

    public void setGame(){
        output.startMonsterRace();

        output.askMONSTERS_COUNT();
        this.MONSTER_COUNT = input.digit();

        output.askCHALLENGE_COUNT();
        this.CHALLENGE_COUNT = input.digit();
    }

    private int makeRandomNumber(int bound){
        int randomValue = random.nextInt(bound);
        if(randomValue>=4){
            return randomValue;
        }
        return 0;
    }

    public void makeMonsters(){
        for (int index = 0; index < MONSTER_COUNT; index++) {
            monsters.add(new Monster(makeRandomNumber(10)));
        }
    }

    public void run() {
        IntStream.range(0, monster.numOfMonster)
                .forEach(count -> System.out.println(monster.move()));
    }
}
