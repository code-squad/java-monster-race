package race.monster.ragdoll;

import java.util.List;
import java.util.ArrayList;

public class RacingGame {
    InputHandler inputHandler = new InputHandler();
    private int numOfMonsters;
    private int numOfTries;
    private List<Monster> monsters = new ArrayList<>();

    private void createMonster(String name, Types type) {
        switch (type) {
            case RUNNER:
                monsters.add(new Runner(name, type));
                break;
            case FLYING:
                monsters.add(new Flying(name, type));
                break;
            case ESPER:
                monsters.add(new Esper(name, type));
                break;
            default:
                throw new IllegalArgumentException("잘못 된 타입을 입력 하였습니다.");
        }
    }

    void configureGameSettings() {
        numOfMonsters = inputHandler.setNumOfMonsters();

        System.out.println("경주할 몬스터 이름과 종류를 입력하세요. (종류 - '달리기', '비행', '에스퍼')");

        for (int i = 0; i < numOfMonsters; i++) {
            inputHandler.setMonsterProperties();
            String name = inputHandler.getNameOfMonster();
            Types type = inputHandler.getTypeOfMonster();
            createMonster(name, type);
        }

        numOfTries = inputHandler.setNumOfTries();
    }

    void startGame() {
        for (Monster monster : monsters) {
            monster.run(numOfTries);
        }

        printResult();
    }

    private void printResult() {
        System.out.println("<실행 결과>");
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
    }
}