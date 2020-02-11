package dev.solar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MonsterRace {
    private Scanner scanner;
    private InputHandler inputHandler;
    private List<Monster> monsters;
    private List<Monster> ranking;
    private List<Monster> winners;
    private int monsterCount;
    private int attemptCount;

    public MonsterRace() {
        this.scanner = new Scanner(System.in);
        this.inputHandler = new InputHandler(scanner);
        this.monsters = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public static void main(String[] args) {
        MonsterRace monsterRace = new MonsterRace();
        monsterRace.play(monsterRace);
    }

    private void play(MonsterRace monsterRace) {
        monsterRace.inputInfo();
        monsterRace.addMonsters();
        monsterRace.move();
        monsterRace.rank();
        monsterRace.pickWinner();
        monsterRace.printResult();
        monsterRace.printWinner();
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
            String inputMonsterName = monsterInfo[0];
            String inputMonsterType = monsterInfo[1];
            MonsterType monsterType = MonsterType.valueOfType(inputMonsterType);

            switch (monsterType) {
                case RUN:
                    return new Run(inputMonsterName, inputMonsterType);
                case FLY:
                    return new Fly(inputMonsterName, inputMonsterType);
                case ESPURR:
                    return new Espurr(inputMonsterName, inputMonsterType);
            }
            throw new IllegalArgumentException("다시 입력해주세요.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("형식에 맞게 입력해주세요. [이름, 타입]");
            return createMonster();
        } catch (IllegalArgumentException e) {
            System.out.println("몬스터 타입은 달리기, 비행, 에스퍼 중에서 골라주세요");
            return createMonster();
        }
    }

    private void move() {
        for (int i = 0; i < attemptCount; i++) {
            monsters.forEach(Monster::move);
        }
    }

    private void rank() {
        Comparator<Monster> comparator = Comparator.comparing(Monster::getForwardPosition);
        ranking = monsters.stream().sorted(comparator.reversed()).collect(Collectors.toList());
    }

    private void pickWinner() {
        int highestScore = ranking.get(0).forwardPosition;
        for (Monster currentMonster : ranking) {
            if (currentMonster.getForwardPosition() != highestScore) {
                break;
            }
            winners.add(currentMonster);
        }
    }

    private void printResult() {
        monsters.forEach(System.out::println);
    }

    private void printWinner() {
        winners.forEach(winner -> System.out.printf("축하합니다! %s(이)가 몬스터 레이스에서 우승했습니다.%n", winner.getMonsterName()));
    }

    private void terminate() {
        scanner.close();
    }
}
