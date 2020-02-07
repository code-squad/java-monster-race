package dev.solar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MonsterRace {
    private InputHandler inputHandler;
    private List<Monster> monsters;
    private int monsterCount;
    private int attemptCount;

    public static void main(String[] args) {
        MonsterRace monsterRace = new MonsterRace();
        monsterRace.inputInfo();
        monsterRace.addMonsters();
        monsterRace.play();
        monsterRace.printResult();
    }

    public MonsterRace() {
        this.inputHandler = new InputHandler();
        this.monsters = new ArrayList<>();
    }

    private void inputInfo() {
        String promptMessage = "몬스터는 모두 몇 마리인가요?";
        monsterCount = inputHandler.inputProperType(promptMessage);
        promptMessage = "시도할 회수는 몇 회 인가요?";
        attemptCount = inputHandler.inputProperType(promptMessage);
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
}
