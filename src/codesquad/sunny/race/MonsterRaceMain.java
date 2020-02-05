package codesquad.sunny.race;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MonsterRaceMain {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int monsterCount;
    private static int tryCount;

    public static void main(String[] args) throws IOException {
        System.out.println("<스릴만점 건전한 몬스터 경주>");
        
        System.out.println("몬스터는 모두 몇 마리인가요?");
        monsterCount = Integer.parseInt(br.readLine());

        System.out.println("시도할 회수는 몇 회 인가요?");
        tryCount = Integer.parseInt(br.readLine());
        
        System.out.println("실행결과");
        racePrint();
    }

    private static int makeRandomCount() {
        Random random  = new Random();
        return random.nextInt(10);
    }

    private static void racePrint() {
        for (int monster = 0; monster < monsterCount ; monster++) {
            for (int chance = 0; chance < tryCount ; chance++) {
                System.out.print(conditionalForward());
            }
            System.out.println();
        }
    }

    private static String conditionalForward() {
        StringBuilder sb = new StringBuilder();
        if (makeRandomCount() > 3) {
            sb.append("-");
        }
        return sb.toString();
    }

}
