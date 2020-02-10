package codesquad.sunny.race;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MonsterRace {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int monsterCount;
    private int attemptCount;
    private final int count = 5;

    public MonsterRace() throws Exception {
        showTitle();
        askMonsterQuantity(count);
        askAttemptCount(count);
        racePrint();
        br.close();
    }

    private void showTitle() {
        System.out.println("<스릴만점 건전한 몬스터 경주>");
    }

    private void askMonsterQuantity(int count) throws Exception {
        if (count == 0) throw new Exception("시도횟수 초과");
        System.out.println("몬스터는 모두 몇 마리인가요?");
        try {
            monsterCount = Integer.parseInt(br.readLine());
            checkNegativeCount(monsterCount);
        } catch (IOException | NegativeNumberException e) {
            askMonsterQuantity(count - 1);
        }
    }

    private void askAttemptCount(int count) throws Exception {
        if (count == 0) throw new Exception("시도횟수 초과");
        System.out.println("시도할 회수는 몇 회 인가요?");
        try {
            attemptCount = Integer.parseInt(br.readLine());
            checkNegativeCount(attemptCount);
        } catch (IOException | NegativeNumberException e) {
            askAttemptCount(count - 1);
        }
    }

    private void checkNegativeCount(int count) throws NegativeNumberException {
        if (count < 0 || count == 0) {
          throw new NegativeNumberException();
        }
    }

    private int makeRandomCount() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private void racePrint() {
        System.out.println("실행결과");
        for (int monster = 0; monster < monsterCount; monster++) {
            attemptForward();
            System.out.println();
        }
    }

    private void attemptForward() {
        for (int chance = 0; chance < attemptCount; chance++) {
            System.out.print(conditionalForward());
        }
    }

    private String conditionalForward() {
        StringBuilder sb = new StringBuilder();
        if (makeRandomCount() > 3) {
            sb.append("-");
        }
        return sb.toString();
    }

}
