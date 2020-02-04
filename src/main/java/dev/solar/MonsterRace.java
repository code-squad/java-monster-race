package dev.solar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MonsterRace {
    List<Monster> monsters = new ArrayList<>();
    int monsterCount;
    int attemptCount;

    public static void main(String[] args) {
        MonsterRace monsterRace = new MonsterRace();
        monsterRace.inputInfo();
        monsterRace.addMonsters();
        monsterRace.play();
        monsterRace.printResult();
    }

    public void inputInfo() {
        try {
            Scanner sc = new Scanner(System.in);
            String promptMonster = "몬스터는 모두 몇 마리인가요?";
            String promptAttempt = "시도할 회수는 몇 회 인가요?";

            System.out.println(promptMonster);
            monsterCount = sc.nextInt();
            System.out.println(promptAttempt);
            attemptCount = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자 값만 입력하실 수 있습니다. 다시 입력해주세요.");
            this.inputInfo();
        }
    }

    public void addMonsters() {
        for (int i = 0; i < monsterCount; i++) {
            monsters.add(new Monster(i));
        }
    }

    public void play() {
        for (int i = 0; i < attemptCount; i++) {
            monsters.forEach(Monster::run);
        }
    }

    public void printResult() {
        Stream<Monster> monsterStream = monsters.stream();
        monsterStream.forEach(monster -> System.out.println(monster));
    }
}
