package race.monster.ragdoll;

import java.io.IOException;
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
        try {
            getUserInput();

            for(Monster monster : monsters) {
                monster.run(numOfTries);
            }

            printResult();
        } catch(NumberFormatException e) {
            System.out.println("숫자만 입력 해주세요.");
            startGame();
        } catch(IOException e) {
            System.out.println("자연수를 입력 해주세요.");
            startGame();
        }
    }

    private void getUserInput() throws IOException{
        System.out.println("<스릴만점 건전한 몬스터 경주>");
        System.out.println("몬스터는 모두 몇 마리인가요?");
        numOfMonsters = Integer.parseInt(scanner.nextLine());

        System.out.println("시도할 회수는 몇 회 인가요?");
        numOfTries = Integer.parseInt(scanner.nextLine());

        if (numOfMonsters < 0 || numOfTries < 0) {
            throw new IOException("음수가 입력 되었습니다.");
        }

        monsters = new Monster[numOfMonsters];
        this.createMonster();
    }

    private void printResult() {
        System.out.println("<실행 결과>");
        for (Monster monster : monsters) {
            System.out.println(monster.toString());
        }
    }
}