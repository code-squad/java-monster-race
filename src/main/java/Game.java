import domain.*;
import util.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Game {

    private BufferedReader bufferedReader;
    private Monsters monsters;
    private int monsterCount, tryCount;
    private int menuNumber;
    private Message message;

    public Game() {
        message = new Message();
        monsters = new Monsters();
    }

    public void run() throws IOException {
        readyGame();
    }


    private void printMainMenu() throws IOException {
        message.printStartMessage();
        selectTopMenu();
    }


    private void readyGame() throws IOException {
        createBufferedReader();
        printMainMenu();
    }

    private void startGame() {
        message.printResultMessage();
        printMonsterForward();
    }

    private void closeGame() throws IOException {
        printWinner();
        message.printCloseMessage();
        monsters.createMonsterLog();
        bufferedReader.close();
    }


    public void createBufferedReader() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private void printMonsterMenu() throws IOException {
        message.printMonsterMessage();
        selectMonsterMenu();
    }

    private void selectTopMenu() throws IOException {
        menuNumber = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);
        switch (menuNumber) {
            case 1:
                printMonsterMenu();
                break;

            case 2:
                if (monsters.getMonsters().isEmpty()) {
                    message.printNoMonstersError();
                    printMainMenu();
                }
                message.printTryCountMessage();
                inputTryCount();
                startGame();
                closeGame();
                break;

            default:
                printMainMenu();
        }
    }

    private void selectMonsterMenu() throws IOException {
        menuNumber = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);

        switch (menuNumber) {
            case 0:
                message.printCloseMessage();
                break;
            case 1:
                showAllMonsters();
                printMonsterMenu();
                break;
            case 2:
                message.printModifyMonsterMessage();
                modifyMonster();
                showAllMonsters();
                printMonsterMenu();
                break;
            case 3:
                message.printMonsterCountMessage();
                inputMonsterCount();
                message.printNameAndTypeMessage();
                inputNameAndType(monsterCount);
                printMainMenu();
                break;
            case 4:
                message.printDeleteMonsterMessage();
                deleteMonster();
                showAllMonsters();
                printMonsterMenu();
                break;
            case 5:
                printMainMenu();
                break;
            default:
                printMonsterMenu();
        }
    }

    private void showAllMonsters() throws IOException {
        printNoMonsterError();
        monsters.printAllMonsters();
    }

    private void modifyMonster() throws IOException {
        String name = Optional.ofNullable(bufferedReader.readLine()).orElse("");
        if (name.equals("") || !isDuplicatedName(name)) throw new IllegalArgumentException("잘못된 이름 입력입니다");
        message.printModifyTypeMessage();
        modifyType(name);
    }

    private void inputMonsterCount() throws IOException {
        monsterCount = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);
        if (monsterCount < 1) throw new IllegalArgumentException("몬스터 숫자는 최소 2이상 입력해주세요");
    }

    private void deleteMonster() throws IOException {
        String name = Optional.ofNullable(bufferedReader.readLine()).orElse("");
        if (name.equals("") || !isDuplicatedName(name)) throw new IllegalArgumentException("잘못된 이름 입력입니다");
        monsters.deleteMonster(name);
    }


    private void inputNameAndType(int monsterCount) throws IOException {
        if (monsterCount == 0) return;
        String[] input = bufferedReader.readLine().trim().split(",");

        if (input.length == 0) throw new IllegalArgumentException("올바르지 않은 이름, 종류 입력입니다");
        String name = input[0];
        String type = input[1].trim();

        if (isDuplicatedName(name)) throw new IllegalArgumentException("중복된 이름입니다.");
        if (!type.equals(MonsterType.RUNNING.getName()) && !type.equals(MonsterType.FLYING.getName()) && !type.equals(MonsterType.PSYCHIC.getName()))
            throw new IllegalArgumentException("올바르지 않은 type 입력입니다. (예시 : running, flying, psychic)");

        createMonster(name, type);
        inputNameAndType(monsterCount - 1);
    }

    private void modifyType(String input) throws IOException {
        String name = input;
        String type = bufferedReader.readLine().trim();

        if (!type.equals(MonsterType.RUNNING.getName()) && !type.equals(MonsterType.FLYING.getName()) && !type.equals(MonsterType.PSYCHIC.getName()))
            throw new IllegalArgumentException("올바르지 않은 type 입력입니다. (예시 : running, flying, psychic)");

        createMonster(name, type);
    }


    private boolean isDuplicatedName(String name) {
        return monsters.getMonsters().containsKey(name);
    }

    private void inputTryCount() throws IOException {
        tryCount = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);
        if (tryCount < 1) throw new IllegalArgumentException("시도 횟수는 1이상 입력해주세요.");
        monsters.addTryCount(tryCount);

    }

    private void createMonster(String name, String type) {
        if (type.equals(MonsterType.RUNNING.getName())) monsters.getMonsters().put(name, new Running(name));
        if (type.equals(MonsterType.FLYING.getName())) monsters.getMonsters().put(name, new Flying(name));
        if (type.equals(MonsterType.PSYCHIC.getName())) monsters.getMonsters().put(name, new Psychic(name));
    }

    private void printNoMonsterError() throws IOException {
        if (monsters.getMonsters().isEmpty()) {
            message.printNoMonstersError();
            printMainMenu();
        }
    }

    private void printMonsterForward() {
        monsters.printMonstersForward();
    }

    private void printWinner() {
        message.printCelebrationMessage(monsters.getWinner());
    }
}
