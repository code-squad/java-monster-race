import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Game {

    Scanner scanner;
    List<Monster> monsterList;
    int monsterCount, attemptCount;
    Message message;

    public Game() {
        monsterList = new ArrayList<>();
        message = new Message();
    }

    public void readyGame() {
        message.startMessage();
        createScanner();
        inputMonsterCount();
        inputAttemptCount();
    }

    public void startGame() {
        createMonsters();
        printMonsterForward();
    }

    public void createScanner() {
        this.scanner = new Scanner(System.in);
    }

    public void inputMonsterCount() {
        message.monsterCountMessage();
        monsterCount = Optional.ofNullable(scanner.nextInt()).orElse(0);
        if (monsterCount == 0) throw new IllegalArgumentException("올바르지 않은 몬스터 갯수 입력입니다");
    }

    public void inputAttemptCount() {
        message.attemptCountMessage();
        attemptCount = Optional.ofNullable(scanner.nextInt()).orElse(0);
        if (attemptCount == 0) throw new IllegalArgumentException("올바르지 않은 시도 횟수 입력입니다");
    }

    public void createMonsters() {
        for (int i = 0; i < monsterCount; i++) {
            monsterList.add(new Monster(attemptCount));
        }
    }

    public void printMonsterForward() {
        message.resultMessage();
        for (int i = 0; i < monsterCount; i++) {
            monsterList.get(i).run();
        }
    }

    public void closeGame() {
        message.closeMessage();
        scanner.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.readyGame();
        game.startGame();
        game.closeGame();
    }
}
