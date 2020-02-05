package race.monster.ragdoll;

import java.util.Scanner;

public class RacingGame {
    private int numOfMonsters;
    private int numOfTries;
    private Monster[] monsters;
    Scanner scanner = new Scanner(System.in);

    public RacingGame() {}

    void createMonster() {
        for (int i = 0; i < numOfMonsters; i++) {
            monsters[i] = new Monster();
        }
    }

    void startGame() {
        for (int i = 0; i < numOfMonsters; i++) {
            monsters[i].run(numOfTries);
        }
    }

    void getNumOfMonster() {
        System.out.println("<스릴만점 건전한 몬스터 경주>");
        System.out.println("몬스터는 모두 몇 마리인가요?");
        numOfMonsters = Integer.parseInt(scanner.nextLine());
        monsters = new Monster[numOfMonsters];
    }

    void getNumOfTries() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        numOfTries = Integer.parseInt(scanner.nextLine());
    }

    void printResult() {
        System.out.println("<실행 결과>");
        for (int i = 0; i < numOfMonsters; i++) {
            System.out.println(monsters[i].toString());
        }
    }
}