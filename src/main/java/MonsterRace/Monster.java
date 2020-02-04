package MonsterRace;

public class Monster {
    /**
     * public int run(roundCount)
     * 몬스터가 이동한 거리를 return 합니다.
     */
    public int run(int roundCount) {
        int distance = 0;

        for (int i = 0; i < roundCount; i++) {
            double cnt = Math.random() * 9;
            distance += (cnt >= 4) ? cnt : 0;
        }

        return distance;
    }
}
