package game;

import java.util.Random;

/**
 * 몬스터의 속성과 기능을 정의한다.
 */
public class Monster {
    private static Random random = new Random();

    private int distance = 0;

    // 몬스터의 움직이는 로직을 구현한다.
    public void move() {
        if(random.nextInt(10) >= 4) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }
}
