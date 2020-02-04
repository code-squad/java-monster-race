package MonsterRace;

public class Monster {
    /**
     * public int getDistance(roundCount)
     * 몬스터가 이동한 거리를 return 합니다.
     */
    public int getDistance(int roundCount) {
        int distance = 0;

        for (int i = 0; i < roundCount; i++) {
            double randomCount = Math.random() * 9;
            distance += (randomCount >= 4) ? randomCount : 0;
        }

        return distance;
    }
}
