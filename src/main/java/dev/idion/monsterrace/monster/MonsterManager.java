package dev.idion.monsterrace.monster;

import dev.idion.monsterrace.util.io.Input;
import dev.idion.monsterrace.util.io.MonsterFileWriter;

import java.io.IOException;

import static dev.idion.monsterrace.StringConstants.PLEASE_SELECT_MENUS_MONSTER;
import static dev.idion.monsterrace.StringConstants.THE_NUMBER_IS_NOT_VALID;

public class MonsterManager {
    private final Input input;
    private final MonsterFileWriter monsterFileWriter;
    private final MonsterCage monsterCage;

    public MonsterManager(Input input) throws IOException {
        this.input = input;
        this.monsterCage = new MonsterCage();
        this.monsterFileWriter = new MonsterFileWriter();
        waitInputMenuNumber();
    }

    private boolean preCheck() {
        if (monsterCage.isEmpty()) return true;
        String monsterName = input.inputMonsterName();
        if (!monsterCage.containsMonster(monsterName)) return true;
        if (input.checkDeleteMonster()) return true;
        monsterCage.remove(monsterName);
        return false;
    }

    private void waitInputMenuNumber() {
        boolean loopCondition = true;
        while (loopCondition) {
            loopCondition = selectMonsterMenu();
        }
        this.close();
    }

    private boolean selectMonsterMenu() {
        switch (input.selectMenu(PLEASE_SELECT_MENUS_MONSTER).getPositiveInt()) {
            case 1:
                return showAllMonsters();
            case 2:
                return modifyMonsterInfo();
            case 3:
                return addNewMonsterInfo();
            case 4:
                return deleteMonsterInfo();
            case 5:
                return false;
            default:
                System.out.println(THE_NUMBER_IS_NOT_VALID);
                return true;
        }
    }

    private boolean showAllMonsters() {
        if (monsterCage.isEmpty()) return true;
        monsterCage.getMonsters().forEach(System.out::println);
        return true;
    }

    private boolean modifyMonsterInfo() {
        if (preCheck()) return true;
        Monster newMonster = input.inputMonsterInfo();
        monsterCage.put(newMonster.getMonsterName(), newMonster);
        return true;
    }

    private boolean addNewMonsterInfo() {
        Monster monster = input.inputMonsterInfo();
        if (monsterCage.containsMonster(monster.getMonsterName(), true)) {
            return true;
        }
        monsterCage.put(monster.getMonsterName(), monster);
        return true;
    }

    private boolean deleteMonsterInfo() {
        preCheck();
        return true;
    }

    private void close() {
        try {
            monsterFileWriter.commit(monsterCage);
            monsterCage.close();
            monsterFileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}