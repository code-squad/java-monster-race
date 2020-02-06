package race.monster.ragdoll;

import java.util.Scanner;

public class RacingGame {
    private int numOfMonsters;
    private int numOfTries;
    private Monster[] monsters;
    Scanner scanner = new Scanner(System.in);

    public RacingGame() {}

    private void createMonster() {
        for (int i = 0; i < numOfMonsters; i++) {
            monsters[i] = new Monster();
        }
    }

    void startGame() {
        this.getNumOfMonster();
        this.getNumOfTries();

        for (int i = 0; i < numOfMonsters; i++) {
            monsters[i].run(numOfTries);
        }

        this.printResult();
    }

    private void getNumOfMonster() {
        System.out.println("<스릴만점 건전한 몬스터 경주>");
        System.out.println("몬스터는 모두 몇 마리인가요?");
        numOfMonsters = Integer.parseInt(scanner.nextLine());
        monsters = new Monster[numOfMonsters];
        this.createMonster();
    }

    private void getNumOfTries() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        numOfTries = Integer.parseInt(scanner.nextLine());
    }

    private void printResult() {
        System.out.println("<실행 결과>");
        for (int i = 0; i < numOfMonsters; i++) {
            System.out.println(monsters[i].toString());
        }
    }
}