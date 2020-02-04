package race.monster.ragdoll;

import java.util.Scanner;

public class GameMachine {
    public static void main(String[] args) {
        RacingGame newGame;

        Scanner scanner = new Scanner(System.in);
        System.out.println("<스릴 만점 건전한 몬스터 경주>");
        System.out.println("몬스터는 모두 몇 마리인가요?");
        int numOfMonsters = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 번인가요?");
        int numOfTries = scanner.nextInt();

        newGame = new RacingGame(numOfMonsters, numOfTries);
        newGame.createMonsters();
        newGame.runMonsters();

        System.out.println("<실행 결과>");
        newGame.printResult();
    }
}
