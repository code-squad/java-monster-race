package MonsterRace_Step1;

import java.util.Scanner;

public class Input {

    public void inputMonster() {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        System.out.println("<스릴 만점 건전한 몬스터 경주>");
        System.out.println("몬스터는 모두 몇마리 인가요?");
        main.setMonsterCnt(sc.nextInt());
        System.out.println("시도할 횟수는 몇회 인가요?");
        main.setMoveCnt(sc.nextInt());
    }
}
