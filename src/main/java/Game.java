import domain.Flying;
import domain.Psychic;
import domain.Running;
import util.Message;
import domain.Monster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Game {

    private Scanner scanner;
    private BufferedReader bufferedReader;
    private List<Monster> monsters;
    private int monsterCount, tryCount;
    private Message message;
    private Monster winner;

    public Game() {
        monsters = new ArrayList<>();
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

        message.monsterCountMessage();
        inputMonsterCount();

        message.nameAndTypeMessage();
        inputNameAndType(this.monsterCount);

        message.attemptCountMessage();
        inputTryCount();
    }

    private void startGame() {
        int index = 0;
        int maxStep = 0;

        message.resultMessage();

        printMonsterForward(index);
        findWinner(maxStep, index);
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
        monsterCount = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);
        if (monsterCount == 0 || monsterCount < 0) throw new IllegalArgumentException("올바르지 않은 몬스터 갯수 입력입니다");
    }

    private void inputNameAndType(int monsterCount) throws IOException {
        if (monsterCount == 0) return;

        String[] input = bufferedReader.readLine().trim().split(",");
        if (input.length == 0) throw new IllegalArgumentException("올바르지 않은 이름, 종류 입력입니다");
        String name = input[0];
        String type = input[1].trim();
        if (!type.equals("running") && !type.equals("flying") && !type.equals("psychic"))
            throw new IllegalArgumentException("올바르지 않은 종류 입력입니다");

        createMonsters(name, type);
        inputNameAndType(monsterCount - 1);
    }

    private void inputTryCount() throws IOException {
        tryCount = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);
        if (tryCount == 0 || tryCount < 0) throw new IllegalArgumentException("올바르지 않은 시도 횟수 입력입니다");
        int index = 0;
        addTryCount(index);
    }

    private void addTryCount(int index) {
        if (index >= monsterCount) return;
        monsters.get(index).attempt(tryCount);
        addTryCount(index + 1);
    }

    private void createMonsters(String name, String type) {
        if (type.equals("running")) monsters.add(new Running(name));
        else if (type.equals("flying")) monsters.add(new Flying(name));
        else if (type.equals("psychic")) monsters.add(new Psychic(name));
    }

    private void printMonsterForward(int index) {
        if (index >= monsterCount) return;
        monsters.get(index).start();
        printMonsterForward(index + 1);
    }

    private void findWinner(int maxStep, int index) {
        if (index >= monsterCount) return;
        if (monsters.get(index).getStep() > maxStep) {
            winner = monsters.get(index);
            maxStep = monsters.get(index).getStep();
        }
        findWinner(maxStep, index + 1);
    }

    private void printWinner() {
        message.winnerMessage(winner.getName());
    }
}
