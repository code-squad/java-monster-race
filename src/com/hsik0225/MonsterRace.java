package com.hsik0225;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MonsterRace {
    public MonsterRace() {
        run();
    }

    public void run() {
        Monster monster = new Monster();

        System.out.println("<실행 결과>");
        IntStream.range(0, monster.numOfMonster)
                .forEach(count -> System.out.println(monster.move()));
    }
}
