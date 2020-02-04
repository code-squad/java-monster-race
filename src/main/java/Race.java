import java.util.ArrayList;
import java.util.Scanner;

public class Race {
    private int monster;
    private int count;
    private ArrayList<Monster> monsters = new ArrayList<>();

    public void racing() {
        System.out.println("몬스터 레이스");
        setting();
        System.out.println("<실행 결과>");
        monsters.forEach(monster -> monster.run(count));
    }

    public void setting() {
        inputMonsterAndCount();
        makeMonster();
    }

    public void inputMonsterAndCount(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("몬스터는 모두 몇 마리인가요?");
        monster = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        count = scanner.nextInt();
    }

    public void makeMonster(){
        for (int i = 0; i < monster; i++) {
            monsters.add(new Monster());
        }
    }
}
