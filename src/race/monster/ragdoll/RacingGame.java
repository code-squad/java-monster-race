package race.monster.ragdoll;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class RacingGame {
    private int numOfMonsters;
    private int numOfTries;
    private List<Monster> monsters = new ArrayList<>();
    InputHandler inputHandler = new InputHandler();

    public RacingGame() {}

    private void createMonster(String name, Types type) {
        switch(type) {
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

    void startGame() {
            inputHandler.setNumOfMonsters();
            numOfMonsters = inputHandler.getNumOfMonsters();

            for(int i = 0; i < numOfMonsters; i++) {
                inputHandler.setMonsterProperties();
                String name = inputHandler.getNameOfMonster();
                Types type = inputHandler.getTypeOfMonster();
                createMonster(name, type);
            }

            inputHandler.setNumOfTries();
            numOfTries = inputHandler.getNumOfTries();

            for(Monster monster : monsters) {
                monster.run(numOfTries);
            }

            printResult();
    }

    private void printResult() {
        System.out.println("<실행 결과>");
        for (Monster monster : monsters) {
            System.out.println(monster.toString());
        }
    }
}