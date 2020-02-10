package dev.idion.monsterrace;

import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.IntStream;

import static dev.idion.monsterrace.StringConstants.*;

public class Game {
    private int attemptCount;
    private int winnerMoveCount;
    private Monster[] monsters;
    private final Map<Integer, List<String>> rankMap;
    private final Input input;
    private final Printer printer;

    public Game() {
        this.rankMap = new HashMap<>();
        this.input = new Input(new Scanner(System.in));
        this.printer = new Printer();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.readyGame();
        game.startGame();
        game.rankMonsters();
        game.printGameResult();
        game.terminateGame(0); // Normal Shutdown
    }

    private void readyGame() {
        System.out.println(GAME_NAME);
        initializeMonsters();
        attemptCount = input.inputValue(ATTEMPT_COUNT_STRING);
    }

    private void initializeMonsters() {
        monsters = new Monster[input.inputValue(MONSTER_COUNT_STRING)];
        inputMonstersInfo();
    }

    private void inputMonstersInfo() {
        System.out.println(INPUT_MONSTER_NAME_AND_TYPE);
        System.out.println(SHOW_MONSTER_TYPES);
        IntStream.range(0, monsters.length).forEach(this::makeMonster);
    }

    private void makeMonster(int index) {
        while (true) {
            try {
                monsters[index] = input.inputMonsterInfo();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(TYPE_NOT_EXIST);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void startGame() {
        randomAttempt();
    }

    private void randomAttempt() {
        Arrays.stream(monsters).forEach(this::attemptMoveMonster);
    }

    private void attemptMoveMonster(Monster monster) {
        for (int i = 0; i < attemptCount; i++) {
            tryMonsterMove(monster);
        }
    }

    private void tryMonsterMove(Monster monster) {
        try {
            monster.move();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(ERROR_MESSAGE);
            terminateGame(126);
        }
    }

    private void printGameResult() {
        printer.printMonstersMovingDistance(monsters);
        printer.printWinnerMonster(rankMap, winnerMoveCount);
    }

    private void rankMonsters() {
        Arrays.stream(monsters)
                .forEach(monster -> {
                    int moveCount = monster.getMoveCount();
                    winnerMoveCount = Math.max(winnerMoveCount, moveCount);
                    List<String> winners = rankMap.getOrDefault(moveCount, new ArrayList<>());
                    winners.add(monster.getMonsterName());
                    rankMap.put(moveCount, winners);
                });
    }

    private void terminateGame(int exitStatus) {
        System.out.println(GAME_EXIT_MESSAGE);
        input.close();
        System.exit(exitStatus);
    }
}