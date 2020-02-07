package dev.solar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MonsterRace {
    Scanner scanner;
    private List<Monster> monsters = new ArrayList<>();
    private int monsterCount;
    private int attemptCount;

    public static void main(String[] args) {
        MonsterRace monsterRace = new MonsterRace();
        monsterRace.inputInfo();
        monsterRace.addMonsters();
        monsterRace.play();
        monsterRace.printResult();
        monsterRace.terminate();
    }

    public MonsterRace() {
        scanner = new Scanner(System.in);
    }

    private void inputInfo() {
        inputMonsterInfo();
        inputAttemptInfo();
    }

    private void inputMonsterInfo() {
        try {
            String promptMonster = "몬스터는 모두 몇 마리인가요?";

            System.out.println(promptMonster);
            monsterCount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자 값만 입력하실 수 있습니다. 다시 입력해주세요.");
            inputMonsterInfo();
        }
    }

    private void inputAttemptInfo() {
        try {
            String promptMonster = "시도할 회수는 몇 회 인가요?";

            System.out.println(promptMonster);
            attemptCount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자 값만 입력하실 수 있습니다. 다시 입력해주세요.");
            inputAttemptInfo();
        }
    }

    private void addMonsters() {
        for (int i = 0; i < monsterCount; i++) {
            monsters.add(new Monster());
        }
    }

    private void play() {
        for (int i = 0; i < attemptCount; i++) {
            monsters.forEach(Monster::run);
        }
    }

    private void printResult() {
        Stream<Monster> monsterStream = monsters.stream();
        monsterStream.forEach(monster -> System.out.println(monster));
    }

    private void terminate() {
        scanner.close();
    }
}
