package dev.idion;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Race {
    private static final String PROMPT = "> ";
    Scanner scanner;
    Monster[] monsters;
    int attemptCount;

    public Race() {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Race race = new Race();
        race.readyGame();
        race.startGame();
        race.terminateGame();
    }

    private void readyGame() {
        System.out.println("<몬스터 경주>");
        inputMonsterCount();
        inputAttemptCount();
    }

    private void inputMonsterCount() {
        System.out.println("몬스터는 모두 몇 마리인가요?");
        System.out.print(PROMPT);
        String input = scanner.nextLine();
        int count = Integer.parseInt(input);
        monsters = new Monster[count];
        fillMonsters();
    }

    private void fillMonsters() {
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Monster();
        }
    }

    private void inputAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        System.out.print(PROMPT);
        String input = scanner.nextLine();
        attemptCount = Integer.parseInt(input);
    }

    private void startGame() {
        try {
            randomAttempt();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("게임 실행 도중 오류가 발생했습니다.");
        }
        System.out.println("<실행 결과>");
        printMonsterMovingDistance();
    }

    private void randomAttempt() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        for (Monster monster : monsters) {
            for (int i = 0; i < attemptCount; i++) {
                moveMonster(random, monster);
            }
        }
    }

    private void moveMonster(Random random, Monster monster) {
        if (random.nextInt(10) > 3) {
            monster.plusMoveCount();
        }
    }

    private void printMonsterMovingDistance() {
        for (Monster monster : monsters) {
            System.out.println(monster.getMovingDistance());
        }
    }

    private void terminateGame() {
        System.out.println("게임을 종료합니다.");
        scanner.close();
    }
}
