import domain.Flying;
import domain.Psychic;
import domain.Runner;
import util.Message;
import domain.Monster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Game {

    Scanner scanner;
    BufferedReader bufferedReader;
    List<Monster> monsterList;
    int monsterCount, attemptCount;
    Message message;
    Monster winner;

    public Game() {
        monsterList = new ArrayList<>();
        message = new Message();
    }

    public void run() throws IOException {
        readyGame();
        startGame();
        closeGame();
    }

    private void readyGame() throws IOException {
        message.startMessage();

        createScanner();
        inputMonsterCount();
        inputNameAndType(this.monsterCount);
        inputAttemptCount();
    }

    private void startGame() {
        printMonsterForward();
        findWinner();
    }

    private void closeGame() {
        printWinner();
        message.closeMessage();
        scanner.close();
    }


    public void createScanner() {
        this.scanner = new Scanner(System.in);
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private void inputMonsterCount() throws IOException {
        message.monsterCountMessage();

        monsterCount = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);
        if (monsterCount == 0 || monsterCount < 0) throw new IllegalArgumentException("올바르지 않은 몬스터 갯수 입력입니다");

        message.nameAndTypeMessage();
    }

    private void inputNameAndType(int monsterCount) throws IOException {
        if (monsterCount == 0) return;

        String[] input = bufferedReader.readLine().trim().split(",");
        if (input.length == 0) throw new IllegalArgumentException("올바르지 않은 이름, 종류 입력입니다");
        String name = input[0];
        String type = input[1].trim();
        if (!type.equals("runner") && !type.equals("flying") && !type.equals("esper"))
            throw new IllegalArgumentException("올바르지 않은 종류 입력입니다");

        createMonsters(name, type);
        inputNameAndType(monsterCount - 1);
    }

    private void inputAttemptCount() {
        message.attemptCountMessage();
        attemptCount = Optional.ofNullable(scanner.nextInt()).orElse(0);
        if (attemptCount == 0 || attemptCount < 0) throw new IllegalArgumentException("올바르지 않은 시도 횟수 입력입니다");
        for (int i = 0; i < monsterCount; i++)
            monsterList.get(i).attempt(attemptCount);
    }

    private void createMonsters(String name, String type) {
        if (type.equals("runner")) monsterList.add(new Runner(name));
        else if (type.equals("flying")) monsterList.add(new Flying(name));
        else if (type.equals("esper")) monsterList.add(new Psychic(name));
    }

    private void printMonsterForward() {
        message.resultMessage();

        for (int i = 0; i < monsterCount; i++)
            monsterList.get(i).start();
    }

    private void findWinner() {
        int maxStep = 0;
        for (int i = 0; i < monsterCount; i++)
            if (monsterList.get(i).getStep() > maxStep) {
                winner = monsterList.get(i);
                maxStep = monsterList.get(i).getStep();
            }
    }

    private void printWinner() {
        message.winnerMessage(winner.getName());
    }


}
