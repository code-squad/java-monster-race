package MonsterRace;

import java.util.Scanner;

public class Game {

    Scanner scanner;
    private int monsterCount;
    private int gameCount;

    public Game() {
        scanner = new Scanner(System.in);
        inputMonsterCount();
        inputGameCount();
        scanner.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        Stadium stadium = new Stadium(game.monsterCount, game.gameCount);
        stadium.printResult();
    }

    private void inputMonsterCount() {
        String monsterCountMessage = "<스릴만점 건전한 몬스터 경주>\n몬스터는 모두 몇 마리인가요?";
        System.out.println(monsterCountMessage);
        setMonsterCount(Integer.parseInt(scanner.nextLine()));
    }

    private void inputGameCount() {
        String gameCountMessage = "시도할 회수는 몇 회 인가요?";
        System.out.println(gameCountMessage);
        setGameCount(Integer.parseInt(scanner.nextLine()));
    }

    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }
}
