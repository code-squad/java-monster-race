import domain.*;
import util.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class Game {

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
        message.printStartMessage();

        createBufferedReader();

        message.printMonsterCountMessage();
        inputMonsterCount();

        message.printNameAndTypeMessage();
        inputNameAndType(this.monsterCount);

        message.printTryCountMessage();
        inputTryCount();
    }

    private void startGame() {
        int index = 0;
        int maxStep = 0;

        message.printResultMessage();

        printMonsterForward(index);
        findWinner(maxStep, index);
    }

    private void closeGame() throws IOException {
        printWinner();
        message.printCloseMessage();
        bufferedReader.close();
    }


    public void createBufferedReader() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private void inputMonsterCount() throws IOException {
        monsterCount = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);
        if (monsterCount == 0 || monsterCount < 0) throw new IllegalArgumentException("몬스터 숫자는 음수 혹은 0이 될 수 없습니다.");
    }

    private void inputNameAndType(int monsterCount) throws IOException {
        if (monsterCount == 0) return;

        String[] input = bufferedReader.readLine().trim().split(",");
        if (input.length == 0) throw new IllegalArgumentException("올바르지 않은 이름, 종류 입력입니다");
        String name = input[0];
        String type = input[1].trim();
        if (!type.equals("running") && !type.equals("flying") && !type.equals("psychic"))
            throw new IllegalArgumentException("올바르지 않은 type 입력입니다. (예시 : running, flying, psychic)");

        createMonster(name, type);
        inputNameAndType(monsterCount - 1);
    }

    private void inputTryCount() throws IOException {
        tryCount = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);
        if (tryCount == 0 || tryCount < 0) throw new IllegalArgumentException("시도 횟수는 음수 혹은 0이 될 수 없습니다.");
        int index = 0;
        addTryCount(index);
    }

    private void addTryCount(int index) {
        if (index >= monsterCount) return;
        monsters.get(index).attempt(tryCount);
        addTryCount(index + 1);
    }

    private void createMonster(String name, String type) {
        if (type.equals(MonsterType.RUNNING.getName())) monsters.add(new Running(name));
        if (type.equals(MonsterType.FLYING.getName())) monsters.add(new Flying(name));
        if (type.equals(MonsterType.PSYCHIC.getName())) monsters.add(new Psychic(name));
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

    public Monster findWinner(Queue<Monster> monsters, int maxStep) {
        if (monsters.isEmpty()) return winner;
        if (monsters.peek().getStep() > maxStep) {
            winner = monsters.poll();
            maxStep = winner.getStep();
        }
        findWinner(monsters, maxStep);
        return winner;
    }


    private void printWinner() {
        message.printCelebrationMessage(winner.getName());
    }
}
