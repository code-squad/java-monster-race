package race.monster.ragdoll;

import java.util.List;
import java.util.ArrayList;

public class RacingGame {
    InputHandler inputHandler = new InputHandler();
    private int numOfMonsters;
    private int numOfTries;
    private List<Monster> monsters = new ArrayList<>();
    private List<Monster> winners = new ArrayList<>();

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

        int maxMoveCount = findMaxValue();
        determineWinners(maxMoveCount);
    }

    private int findMaxValue() {
        int maxValue = 0;

        for (Monster monster : monsters) {
            if (maxValue <= monster.moveCount) {
                maxValue = monster.moveCount;
            }
        }
        return maxValue;
    }

    private void determineWinners(int maxValue) {
        for (Monster monster : monsters) {
            if (monster.moveCount == maxValue) {
                winners.add(monster);
            }
        }
    }

    void finishGame() {
        System.out.println("<실행 결과>");
        for (Monster monster : monsters) {
            System.out.println(monster);
        }

        StringBuilder stringBuilder = new StringBuilder("우승자는 ");
        for (Monster monster : winners) {
            stringBuilder.append(monster.getName()).append(" ");
        }

        String printWinners = stringBuilder.append("입니다. 축하 합니다!").toString();
        System.out.println(printWinners);
    }
}