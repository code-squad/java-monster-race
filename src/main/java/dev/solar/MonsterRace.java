package dev.solar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MonsterRace {
    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String promptMonster = "몬스터는 모두 몇 마리인가요?";
        String promptAttempt = "시도할 회수는 몇 회 인가요?";

        System.out.println(promptMonster);
        int monsterCnt = sc.nextInt();
        System.out.println(promptAttempt);
        int attemptCnt = sc.nextInt();

        for (int i = 0; i < monsterCnt; i++) {
            monsters.add(new Monster(i));
        }

        for (int i = 0; i < attemptCnt; i++) {
            monsters.forEach(Monster::setRandomCount);
        }

        Stream<Monster> monsterStream = monsters.stream();
        monsterStream.forEach(monster -> System.out.println(monster.toString()));
    }
}
