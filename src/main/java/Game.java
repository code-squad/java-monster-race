import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        monsterCount = Optional.ofNullable(scanner.nextInt()).orElse(0);
        if(monsterCount == 0) throw new IllegalArgumentException("올바르지 않은 몬스터 갯수 입력입니다");
    }

    private void inputAttemptCount(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        attemptCount = Optional.ofNullable(scanner.nextInt()).orElse(0);
        if(attemptCount == 0) throw new IllegalArgumentException("올바르지 않은 시도 횟수 입력입니다");
    }
    private void createMonsters() {
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
