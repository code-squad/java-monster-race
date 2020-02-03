package dev.idion;

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
    }

    private void inputAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        System.out.print(PROMPT);
        String input = scanner.nextLine();
        attemptCount = Integer.parseInt(input);
    }

    private void startGame() {
        System.out.println("<실행 결과>");
    }

    private void terminateGame() {
        System.out.println("게임을 종료합니다.");
        scanner.close();
    }
}
