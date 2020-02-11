import domain.*;
import util.Log;
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
    private Monsters monsters;
    private int monsterCount, tryCount;
    private Message message;
    private Monster winner;
    private Log log;

    public Game() {
        message = new Message();
        monsters = new Monsters();
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
        message.printResultMessage();

        printMonsterForward();
        winner = monsters.getWinner();

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

        if (!type.equals(MonsterType.RUNNING.getName()) && !type.equals(MonsterType.FLYING.getName()) && !type.equals(MonsterType.PSYCHIC.getName()))
            throw new IllegalArgumentException("올바르지 않은 type 입력입니다. (예시 : running, flying, psychic)");

        createMonster(name, type);
        inputNameAndType(monsterCount - 1);
    }

    private void inputTryCount() throws IOException {
        tryCount = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);
        if (tryCount == 0 || tryCount < 0) throw new IllegalArgumentException("시도 횟수는 음수 혹은 0이 될 수 없습니다.");
        monsters.addTryCount(tryCount);

    }

    private void createMonster(String name, String type) {
        if (type.equals(MonsterType.RUNNING.getName())) monsters.getMonsters().put(name, new Running(name));
        if (type.equals(MonsterType.FLYING.getName())) monsters.getMonsters().put(name, new Flying(name));
        if (type.equals(MonsterType.PSYCHIC.getName())) monsters.getMonsters().put(name, new Psychic(name));
    }

    private void printMonsterForward() {
        monsters.printMonstersForward();
    }

    private void printWinner() {
        message.printCelebrationMessage(winner.getName());
    }
}
