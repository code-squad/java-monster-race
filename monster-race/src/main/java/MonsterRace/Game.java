package MonsterRace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static MonsterRace.MonsterType.*;

public class Game {

    Scanner scanner;
    private int monsterCount;
    private int gameCount;
    private List<String[]> monstersInfo = new ArrayList<>();

    public Game() {
        gameStart();
    }

    public static void main(String[] args) {
        Game game = new Game();
        Stadium stadium = game.createStadium();
        stadium.printResult();
    }

    private void gameStart() {
        String monsterCountMessage = "<스릴만점 건전한 몬스터 경주>\n몬스터는 모두 몇 마리인가요?";
        String monsterInfoMessage = "경주할 몬스터 이름과 종류를 입력하세요 (쉼표(,)를 기준으로 구분).";
        String gameCountMessage = "시도할 회수는 몇 회 인가요?";
        scanner = new Scanner(System.in);

        System.out.println(monsterCountMessage);
        monsterCount = inputMonsterCount();
        System.out.println(monsterInfoMessage);
        inputMonsterInfo();
        System.out.println(gameCountMessage);
        gameCount = inputGameCount();
        scanner.close();
    }

    private Stadium createStadium() {
        return new Stadium(gameCount, monstersInfo);
    }

    private int inputMonsterCount() {
        String monsterCountErrorMessage = "올바르지 않은 값이 입력되되었습니다.\n몬스터는 모두 몇 마리 인가요?";
        int tempMonsterCount;
        try {
            tempMonsterCount = Integer.parseInt(scanner.nextLine());
            if (tempMonsterCount <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println(monsterCountErrorMessage);
            return inputMonsterCount();
        }
        return tempMonsterCount;
    }

    private void inputMonsterInfo() {
        int monstersInfoSize = monstersInfo.size();
        while (monstersInfoSize < monsterCount) {
            monstersInfo.add(checkMonsterInfo());
            monstersInfoSize = monstersInfo.size();
        }
    }

    private String[] checkMonsterInfo() {
        String monsterNameType = scanner.nextLine();
        String[] monsterInfo = monsterNameType.split(",");

        if (AIR.getmonsterType().equals(monsterInfo[1])) {
            return monsterInfo;
        }
        if (RUN.getmonsterType().equals(monsterInfo[1])) {
            return monsterInfo;
        }
        if (ESPER.getmonsterType().equals(monsterInfo[1])) {
            return monsterInfo;
        }
        System.out.println("몬스터 정보가 잘못되었습니다. 올바른 몬스터 정보를 입력하세요!");
        return checkMonsterInfo();
    }

    private int inputGameCount() {
        String gameCountErrorMessage = "올바르지 않은 값이 입력되되었습니다.\n시도 횟수는 몇회 인가요?";
        int tempGameCount;
        try {
            tempGameCount = Integer.parseInt(scanner.nextLine());
            if (tempGameCount <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println(gameCountErrorMessage);
            return inputGameCount();
        }
        return tempGameCount;
    }
}