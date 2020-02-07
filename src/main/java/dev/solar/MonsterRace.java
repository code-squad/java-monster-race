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

    private MonsterRace() {
        scanner = new Scanner(System.in);
    }

    private void inputInfo() {
        inputMonsterInfo();
        inputAttemptInfo();
    }

    private void inputMonsterInfo() {
        String promptMonster = "몬스터는 모두 몇 마리인가요?";
        monsterCount = inputProperType(promptMonster);
    }

    private void inputAttemptInfo() {
        String promptMonster = "시도할 회수는 몇 회 인가요?";
        attemptCount = inputProperType(promptMonster);
    }

    private Integer inputProperType(String promptMesssage) {
        int inputValue;
        try {
            System.out.println(promptMesssage);
            inputValue = Integer.parseInt(scanner.nextLine());
            return inputValue;
        } catch (NumberFormatException e) {
            System.out.println("숫자 값만 입력하실 수 있습니다. 다시 입력해주세요.");
            return inputProperType(promptMesssage);
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
