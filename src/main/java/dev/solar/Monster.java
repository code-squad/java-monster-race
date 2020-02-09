package dev.solar;

import java.util.Random;
import java.util.stream.IntStream;

public class Monster {
    private String monsterName;
    private MonsterType monsterType;
    private int minCriteria;
    private int forwardCount;

    public void move() {
        int randomValue = new Random().nextInt(10) + 1;
        System.out.println("randomVale : " + randomValue);
        if (randomValue >= minCriteria) {
            forwardCount += randomValue;
        }
    }

    public Monster(String monsterName, String monsterType) {
        try {
            this.monsterName = monsterName;
            this.monsterType = MonsterType.valueOfType(monsterType);
            this.minCriteria = this.monsterType.getMinCriteria();
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
        sb.append(monsterName).append(" [").append(monsterType.type).append("] : ");
        IntStream.range(0, forwardCount).forEach(i -> sb.append("-"));
        return sb.toString();
    }
}
