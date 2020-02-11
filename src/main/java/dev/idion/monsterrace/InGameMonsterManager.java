package dev.idion.monsterrace;

import dev.idion.monsterrace.io.Input;
import dev.idion.monsterrace.monster.Monster;

import java.util.Arrays;

import static dev.idion.monsterrace.StringConstants.ATTEMPT_COUNT_STRING;
import static dev.idion.monsterrace.StringConstants.INPUT_MONSTER_NAME_AND_TYPE;
import static dev.idion.monsterrace.StringConstants.MONSTER_COUNT_STRING;
import static dev.idion.monsterrace.StringConstants.SHOW_MONSTER_TYPES;

public class InGameMonsterManager {
    private int attemptCount;
    private Monster[] monsters;
    private Input input;

    public InGameMonsterManager(Input input) {
        this.input = input;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public void inputAttemptCount() {
        attemptCount = input.inputPositiveValue(ATTEMPT_COUNT_STRING);
    }

    public void initializeMonsters() {
        monsters = new Monster[input.inputPositiveValue(MONSTER_COUNT_STRING)];
        inputMonstersInfo();
    }

    private void inputMonstersInfo() {
        System.out.println(INPUT_MONSTER_NAME_AND_TYPE);
        System.out.println(SHOW_MONSTER_TYPES);
        int monsterCount = monsters.length;
        for (int i = 0; i < monsterCount; i++) {
            makeMonster(i);
        }
    }

    private void makeMonster(int index) {
        while (true) {
            try {
                monsters[index] = input.inputMonsterInfo();
                break;
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void moveMonsters() {
        Arrays.stream(monsters).forEach(this::moveMonster);
    }

    private void moveMonster(Monster monster) {
        for (int i = 0; i < attemptCount; i++) {
            monster.move();
        }
    }
}