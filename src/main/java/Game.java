import util.Message;

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

    public void run() {
        readyGame();
        startGame();
        closeGame();
    }

    private void readyGame() {
        message.startMessage();
        createScanner();
        inputMonsterCount();
        inputAttemptCount();
    }

    private void startGame() {
        createMonsters();
        printMonsterForward();
    }

    private void closeGame() {
        message.closeMessage();
        scanner.close();
    }


    public void createScanner() {
        this.scanner = new Scanner(System.in);
    }

    private void inputMonsterCount() {
        message.monsterCountMessage();
        monsterCount = Optional.ofNullable(scanner.nextInt()).orElse(0);
        if (monsterCount == 0 || monsterCount < 0) throw new IllegalArgumentException("올바르지 않은 몬스터 갯수 입력입니다");
    }

    private void inputAttemptCount() {
        message.attemptCountMessage();
        attemptCount = Optional.ofNullable(scanner.nextInt()).orElse(0);
        if (attemptCount == 0 || attemptCount <0 ) throw new IllegalArgumentException("올바르지 않은 시도 횟수 입력입니다");
    }

    private void createMonsters() {
        for (int i = 0; i < monsterCount; i++) {
            monsterList.add(new Monster(attemptCount));
        }
    }

    private void printMonsterForward() {
        message.resultMessage();
        for (int i = 0; i < monsterCount; i++) {
            monsterList.get(i).run();
        }
    }


}
