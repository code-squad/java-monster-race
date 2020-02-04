import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    Scanner scanner;
    List<Monster> monsterList;
    int monsterCount, attemptCount;

    public Game() {
        this.scanner = new Scanner(System.in);
        monsterList = new ArrayList<>();
    }

    public void readyGame(){
        System.out.println("<스릴만점 건전한 몬스터 경주>");
        inputMonsterCount();
        inputAttemptCount();
    }

    public void startGame(){
        createMonsters();
        printMonsterForward();
    }

    private void inputMonsterCount(){
        System.out.println("몬스터는 모두 몇 마리인가요?");
        monsterCount = scanner.nextInt();
    }

    private void inputAttemptCount(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        attemptCount = scanner.nextInt();
    }
    private void createMonsters(){
        for (int i = 0; i < monsterCount; i++) {
            monsterList.add(new Monster(attemptCount));
        }
    }

    private void printMonsterForward(){
        System.out.println("<실행 결과>");
        for (int i = 0; i < monsterCount; i++) {
            monsterList.get(i).run();
        }
    }

    public void closeGame(){
        System.out.println("<게임을 종료합니다>");
        scanner.close();
    }

    public static void main(String[] args) {
            Game game = new Game();
            game.readyGame();
            game.startGame();
            game.closeGame();
    }
}
