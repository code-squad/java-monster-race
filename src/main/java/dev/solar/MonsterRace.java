package dev.solar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MonsterRace {
    List<Monster> monsters = new ArrayList<>();
    Scanner scanner;
    int monsterCount;
    int attemptCount;

    public static void main(String[] args) {
        MonsterRace monsterRace = new MonsterRace();
        monsterRace.ready();
        monsterRace.inputInfo();
        monsterRace.addMonsters();
        monsterRace.play();
        monsterRace.printResult();
        monsterRace.terminate();
    }

    public void ready() {
        this.scanner = new Scanner(System.in);
    }

    public void inputInfo() {
        inputMonsterInfo();
        inputAttemptInfo();
    }

    public void inputMonsterInfo() {
        try {
            String promptMonster = "몬스터는 모두 몇 마리인가요?";

            System.out.println(promptMonster);
            monsterCount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자 값만 입력하실 수 있습니다. 다시 입력해주세요.");
            inputMonsterInfo();
        }
    }

    public void inputAttemptInfo() {
        try {
            String promptMonster = "시도할 회수는 몇 회 인가요?";

            System.out.println(promptMonster);
            attemptCount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자 값만 입력하실 수 있습니다. 다시 입력해주세요.");
            inputAttemptInfo();
        }
    }

    public void addMonsters() {
        for (int i = 0; i < monsterCount; i++) {
            monsters.add(new Monster());
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

    public void terminate() {
        scanner.close();
    }
}
