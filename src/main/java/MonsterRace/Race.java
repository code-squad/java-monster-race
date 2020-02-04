package MonsterRace;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Race {
    int roundCount;
    List<Monster> monsters;

    public Race() {
        monsters = new ArrayList<Monster>();
    }

    /**
     * public void startRace()
     * 입력 값을 받고 기본적인 validation 을 체크 합니다.
     */
    public void startRace() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("<스릴만점 건전한 몬스터 경주>");
            System.out.println("몬스터는 모두 몇 마리인가요?");
            IntStream.range(0, Integer.parseInt(br.readLine()))
                    .forEach(i -> monsters.add(new Monster()));

            System.out.println("시도할 회수는 몇 회 인가요?");
            this.roundCount = Integer.parseInt(br.readLine());

            br.close();
        } catch (Exception e) {
            System.out.println("### Input Fail : 각 입력 값은 Integer 의 범위에 있어야 합니다.");
        }
    }

    /**
     * public void resultsOfMatch()
     * monster.run() 을 호출하여 distance 를 구하고 그만큼 "-" 를 출력해줍니다.
     */
    public void resultsOfMatch() {
        System.out.println("\n<실행 결과>");

        monsters.stream().forEach(monster -> {
            int distance = monster.run(roundCount);
            IntStream.range(0, distance).forEach(i -> System.out.print("-"));
            System.out.println();
        });
    }
}
