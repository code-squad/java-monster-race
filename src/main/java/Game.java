import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        List<Monster> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("<스릴만점 건전한 몬스터 경주>");
        System.out.println("몬스터는 모두 몇 마리인가요?");
        int monsterCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int runCount = scanner.nextInt();

        for (int i = 0; i < monsterCount; i++) {
            list.add(new Monster(runCount));
        }
        System.out.println("<실행 결과>");
        for (int i = 0; i < monsterCount; i++) {
            list.get(i).run();
        }
    }
}
