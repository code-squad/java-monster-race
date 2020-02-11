package controller;

import domain.Game;
import domain.MonsterType;
import domain.Monsters;
import domain.monster.Flying;
import domain.monster.Psychic;
import domain.monster.Running;
import util.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class Menu {
    private BufferedReader bufferedReader;
    private Game game;
    private Monsters monsters;
    private int inputNumber;
    private Message message;
    private int monsterCount, tryCount;

    public Menu() {
        this.message = new Message();
        this.game = new Game();
    }

    public void start() {
        monsters = game.readyGame();
        ready();
    }

    private void ready() {
        createBufferedReader();
        printMainMenu();
    }

    private void createBufferedReader() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private void printMainMenu() {
        message.printStartMessage();
        mainMenu();
    }

    private void printSubMenu() {
        message.printSubMessage();
        subMenu();
    }

    private void mainMenu() {

        try {
            inputNumber = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);
        } catch (IOException e) {
            message.printInputError();
            printMainMenu();
        }

        switch (inputNumber) {
            case 0:
                message.printCloseMessage();
                break;

            case 1:
                printSubMenu();
                break;

            case 2:
                mainCheckMonsters();
                isGameStart();
                message.printTryCountMessage();
                inputTryCount();

                game.startGame(monsters);
                game.closeGame(monsters);
                break;

            default:
                printMainMenu();
                break;
        }
    }


    private void subMenu() {

        try {
            inputNumber = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);
        } catch (IOException | NumberFormatException e) {
            message.printInputError();
            printSubMenu();
        }

        switch (inputNumber) {
            case 1:
                showAllMonsters();
                printSubMenu();
                break;

            case 2:
                subCheckMonsters();
                message.printModifyMonsterMessage();
                modifyMonster();
                printSubMenu();
                break;

            case 3:
                message.printMonsterCountMessage();
                inputMonsterCount();
                message.printNameAndTypeMessage();
                inputNameAndType(monsterCount);
                printSubMenu();
                break;

            case 4:
                subCheckMonsters();
                message.printDeleteMonsterMessage();
                deleteMonster();
                printSubMenu();
                break;

            case 5:
                printMainMenu();
                break;

            default:
                printSubMenu();
        }
    }

    private void showAllMonsters() {
        subCheckMonsters();
        monsters.printAllMonsters();
    }

    private void modifyMonster() {
        String name = "";

        try {
            name = Optional.ofNullable(bufferedReader.readLine()).orElse("");
            if (name.equals("") || !isDuplicatedName(name)) throw new IllegalArgumentException();
        } catch (IllegalArgumentException | IOException e) {
            message.printInputError();
            modifyMonster();
        }

        message.printModifyTypeMessage();
        modifyMonsterType(name);
    }

    private void inputMonsterCount() {
        try {
            monsterCount = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);
            if (monsterCount < 1) throw new IllegalArgumentException();
        } catch (IllegalArgumentException | IOException e) {
            message.printMonsterCountError();
            inputMonsterCount();
        }
    }

    private void deleteMonster() {
        String name = "";
        try {
            name = Optional.ofNullable(bufferedReader.readLine()).orElse("");
            if (name.equals("") || !isDuplicatedName(name)) throw new IllegalArgumentException();
        } catch (IllegalArgumentException | IOException e) {
            message.printInputError();
            deleteMonster();
        }
        monsters.deleteMonster(name);
    }


    private void inputNameAndType(int monsterCount) {
        String[] input = new String[2];

        if (monsterCount == 0) return;

        try {
            input = bufferedReader.readLine().trim().split(",");
            if (input.length == 0) throw new IllegalArgumentException();
        } catch (IOException | IllegalArgumentException e) {
            message.printInputError();
            inputNameAndType(monsterCount);
        }
        checkNameAndType(input);
        inputNameAndType(monsterCount - 1);
    }

    private void modifyMonsterType(String input) {
        String name = input;
        String type = "";

        try {
            type = bufferedReader.readLine().trim();
            if (!type.equals(MonsterType.RUNNING.getName()) && !type.equals(MonsterType.FLYING.getName()) && !type.equals(MonsterType.PSYCHIC.getName()))
                throw new IllegalArgumentException();
        } catch (Exception e) {
            message.printTypeError();
            modifyMonsterType(name);
        }
        createMonster(name, type);
    }


    private boolean isDuplicatedName(String name) {
        return monsters.getMonsters().containsKey(name);
    }

    private void inputTryCount() {
        try {
            tryCount = Optional.ofNullable(Integer.parseInt(bufferedReader.readLine())).orElse(0);
            if (tryCount < 1) throw new IllegalArgumentException();
        } catch (IllegalArgumentException | IOException e) {
            message.printTryCountError();
            inputTryCount();
        }
        monsters.addTryCount(tryCount);
    }

    private void createMonster(String name, String type) {
        if (type.equals(MonsterType.RUNNING.getName())) monsters.getMonsters().put(name, new Running(name));
        if (type.equals(MonsterType.FLYING.getName())) monsters.getMonsters().put(name, new Flying(name));
        if (type.equals(MonsterType.PSYCHIC.getName())) monsters.getMonsters().put(name, new Psychic(name));
    }

    private void checkNameAndType(String[] input) {
        String name = input[0];
        String type = input[1].trim();

        try {
            if (isDuplicatedName(name)) throw new IllegalArgumentException();
            if (!type.equals(MonsterType.RUNNING.getName()) && !type.equals(MonsterType.FLYING.getName()) && !type.equals(MonsterType.PSYCHIC.getName()))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            message.printCheckNameAndTypeError();
            printSubMenu();
        }
        createMonster(name, type);
    }

    private void mainCheckMonsters() {
        if (monsters.getMonsters().isEmpty()) {
            message.printNoMonstersError();
            printMainMenu();
        }
    }

    private void subCheckMonsters() {
        if (monsters.getMonsters().isEmpty()) {
            message.printNoMonstersError();
            printSubMenu();
        }
    }

    private void isGameStart() {
        if(monsters.getMonsters().size() < 2) {
            message.printNotEnoughMonsters();
            printSubMenu();
        }
    }


}
