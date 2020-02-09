package dev.solar;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Monster {
    private String monsterName;
    private MonsterType monsterType;
    private int minCriteria;
    private int forwardCount;

    public void move() {
        int random = (int) (Math.random() * 10);
        if (random >= 4) {
            forwardCount += random;
        }
    }

    public Monster(String monsterName, String monsterType) {
        try {
            this.monsterName = monsterName;
            this.monsterType = MonsterType.valueOfType(monsterType);
        } catch(IllegalArgumentException e) {
            System.out.println("몬스터 타입은 달리기, 비행, 에스퍼 중에서 골라주세요");
            throw e;
        }
    }

//    public boolean isAboveMinCriteria() {
//        return true;
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, forwardCount).forEach(i -> sb.append("-"));
        return sb.toString();
    }
}
