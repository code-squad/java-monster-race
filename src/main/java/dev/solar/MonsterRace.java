package dev.solar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MonsterRace {
    private Scanner scanner;
    private InputHandler inputHandler;
    private List<Monster> monsters;
    private int monsterCount;
    private int attemptCount;

    public MonsterRace() {
        scanner = new Scanner(System.in);
        inputHandler = new InputHandler(scanner);
        monsters = new ArrayList<>();
    }

    public static void main(String[] args) {
        MonsterRace monsterRace = new MonsterRace();
        monsterRace.play(monsterRace);
    }

    private void play(MonsterRace monsterRace) {
        monsterRace.inputInfo();
        monsterRace.addMonsters();
        monsterRace.move();
        monsterRace.printResult();
        monsterRace.terminate();
    }

    private void inputInfo() {
        String promptMessage = "몬스터는 모두 몇 마리인가요?";
        monsterCount = inputHandler.inputProperType(promptMessage);
        promptMessage = "시도할 회수는 몇 회 인가요?";
        attemptCount = inputHandler.inputProperType(promptMessage);
    }

    private void addMonsters() {
        String promptMessage = "경주할 몬스터 이름과 종류를 입력하세요.(쉼표(,)를 기준으로 구분)";
        System.out.println(promptMessage);
        for (int i = 0; i < monsterCount; i++) {
            Monster monster = createMonster();
            monsters.add(monster);
        }
    }

    private Monster createMonster() {
        try {
            String[] monsterInfo = inputHandler.inputMonsterInfo();
            String monsterName = monsterInfo[0];
            String monsterType = monsterInfo[1];
            // TODO : 각 타입별로 몬스터 생성
            return new Espurr(monsterName, monsterType);
        } catch (ArrayIndexOutOfBoundsException e) { //구분자 에러 처리
            System.out.println("형식에 맞게 입력해주세요.");
            return createMonster();
        } catch (IllegalArgumentException e) {
            return createMonster();
        }
    }

    private void move() {
        for (int i = 0; i < attemptCount; i++) {
            monsters.forEach(Monster::move);
        }
    }

    private void printResult() {
        Stream<Monster> monsterStream = monsters.stream();
        monsterStream.forEach(System.out::println);
    }

    private void terminate() {
        scanner.close();
    }
}
