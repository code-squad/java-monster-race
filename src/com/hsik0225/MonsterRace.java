package com.hsik0225;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MonsterRace {
    private Input input;
    private Output output;

    public MonsterRace(){
        input = new Input();
        output = new Output();
    }

    public void setGame(){
        output.startMonsterRace();

        output.askMONSTERS_COUNT();
        final int MONSTER_COUNT = input.input();

        output.askCHALLENGE_COUNT();
        final int CHALLENGE_COUNT = input.input();
    }

    public void run() {
        Monster monster = new Monster();

        System.out.println("<실행 결과>");
        IntStream.range(0, monster.numOfMonster)
                .forEach(count -> System.out.println(monster.move()));
    }
}
