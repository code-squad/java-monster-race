import movestrategy.MoveStrategy;
import movestrategy.MoveStrategyFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RaceInitializer {
    private BufferedReader in;

    public RaceInitializer() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void initializeRace(Race race) {
        System.out.println("<Monster Race!>");
        race.setMonsters(readMonsters());
        race.setTotalRounds(readNumRound());
    }

    private List<Monster> readMonsters() {
        List<Monster> monsters = new ArrayList<>();
        int numMonster = readNumMonster();
        System.out.println("Monster name and strategy?\n" +
                "Available strategies: run, fly, espurr\n" +
                "e.g. Honux, espurr");
        for (int i = 0; i < numMonster; i++) {
            monsters.add(readMonsterInfo());
            System.out.println("OK");
        }
        return monsters;
    }

    private int readNumMonster() {
        System.out.println("Number of monsters?");
        return readInt();
    }

    private int readInt() {
        try {
            int returnValue = Integer.parseInt(in.readLine());
            if (returnValue <= 0) { throw new InvalidRangeException(); }
            System.out.println("OK");
            return returnValue;
        } catch (NumberFormatException | InvalidRangeException e) {
            System.err.println("Must be a positive integer.");
            return readInt();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private Monster readMonsterInfo() {
        try {
            String input = in.readLine();
            validateFormatOf(input); // may throw MonsterInfoFormatException
            return initMonster(input); // may throw IllegalArgumentException
        } catch (MonsterInfoFormatException | IllegalArgumentException e) {
            System.err.println("Invalid monster info. Try again.");
            return readMonsterInfo();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void validateFormatOf(String input) {
        if (!input.matches("\\w+, \\w+")) {
            throw new MonsterInfoFormatException();
        }
    }

    private Monster initMonster(String input) {
        final int NAME_INDEX = 0;
        final int STRATEGY_INDEX = 1;
        String[] splitInput = input.split(", ");
        String monsterName = splitInput[NAME_INDEX];
        String moveStrategyName = splitInput[STRATEGY_INDEX];
        MoveStrategy moveStrategy = MoveStrategyFactory.SINGLETON.produceStrategy(moveStrategyName); // may throw IllegalArgumentException
        return new Monster(monsterName, moveStrategy);
    }

    private int readNumRound() {
        System.out.println("Number of rounds?");
        return readInt();
    }

    private static class InvalidRangeException extends RuntimeException {}

    private static class MonsterInfoFormatException extends RuntimeException {}
}
