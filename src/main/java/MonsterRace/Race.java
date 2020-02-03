package MonsterRace;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Race {
    /**
     * The Round cnt : 총 라운드 수
     * The Monsters : 몬스터의 정보가 담긴 Set
     */
    int roundCnt;
    Set<Monster> monstersNum;

    public Race() {
        monstersNum = new HashSet<>();
    }

    /**
     * public void startRace()
     * 입력 값을 받고 기본적인 validation 을 체크 합니다.
     */
    public void startRace() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input;

        try {
            System.out.println("<스릴만점 건전한 몬스터 경주>");

            System.out.println("몬스터는 모두 몇 마리인가요?");
            input = Integer.parseInt(br.readLine());

            for (int i = 0; i < input; i++) {
                monstersNum.add(new Monster());
            }

            System.out.println("시도할 회수는 몇 회 인가요?");
            this.roundCnt = Integer.parseInt(br.readLine());

            br.close();
        } catch (Exception e) {
            System.out.println("### Input Fail : 각 입력 값은 Integer 의 범위에 있어야 합니다.");
        }
    }

    /**
     * private int movedDistance()
     * 몬스터가 이동한 거리를 return 합니다.
     */
    private int movedDistance() {
        int distance = 0;

        for (int i = 0; i < roundCnt; i++) {
            double cnt = Math.random() * 9;
            distance += (cnt >= 4) ? cnt : 0;
        }

        return distance;
    }

    /**
     * public void resultsOfMatch()
     * movedDistance() 의 return 값을 기반으로 이동한 거리를 출력해줍니다.
     */
    public void resultsOfMatch() {
        System.out.println("\n<실행 결과>");

        for (int i = 0; i < monstersNum.size(); i++) {
            for (int j = 0; j < movedDistance(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
