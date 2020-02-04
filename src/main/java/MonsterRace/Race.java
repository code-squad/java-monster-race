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
            System.out.println(TextTemplate.START_RACE.getText());
            System.out.println(TextTemplate.Q_MONSTER_COUNT.getText());
            IntStream.range(0, Integer.parseInt(br.readLine()))
                    .forEach(i -> monsters.add(new Monster()));

            System.out.println(TextTemplate.Q_ROUND_COUNT.getText());
            this.roundCount = Integer.parseInt(br.readLine());

            br.close();
        } catch (Exception e) {
            System.out.println(TextTemplate.INPUT_ERR.getText());
        }
    }

    /**
     * public void resultsOfMatch()
     * monster.run() 을 호출하여 distance 를 구하고 그만큼 "-" 를 출력해줍니다.
     */
    public void resultsOfMatch() {
        System.out.println("\n<실행 결과>");

        for (int i = 0; i < monsters.size(); i++) {
            IntStream.range(0, monsters.get(i).run(roundCount))
                    .forEach(notUse -> System.out.print("-"));
            System.out.println();
        }
    }
}
