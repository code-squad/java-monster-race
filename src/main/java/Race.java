import java.util.ArrayList;
import java.util.Scanner;

public class Race {
    private int monster;
    private int count;
    private ArrayList<Monster> monsters = new ArrayList<>();

    public void racing(){
        setting();
        System.out.println("<실행 결과>");
//        monsters.forEach(monster -> monster.run());
        monsters.forEach(Monster::run);
    }

    public void setting(){
        System.out.println("몬스터는 모두 몇 마리인가요?");
        Scanner scanner = new Scanner(System.in);
        monster = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        count = scanner.nextInt();
        for(int i=0; i<monster; i++){
            monsters.add(new Monster(count));
        }
    }
}
