package game;

import java.util.Random;

// 몬스터 객체의 속성인 거리를 관리한다.
public class Monster {
    private static final Random random = new Random();
    private int distance;

    Monster() {
        distance = 0;
    }

    public void move() {
        if(random.nextInt(10) >= 4) {
            distance++;
        }
    }

    String getDistance() {
        StringBuilder buffer = new StringBuilder();

        for(int i=0; i<distance; i++) {
            buffer.append("-");
        }

        return buffer.toString();
    }
}
