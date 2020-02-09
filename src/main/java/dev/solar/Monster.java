package dev.solar;

import java.util.Random;
import java.util.stream.IntStream;

abstract class Monster {
    private String monsterName;
    private MonsterType monsterType;
    private int minCriteria;
    protected int forwardCount;
    public int forwardPosition;

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

    abstract void setForwardCount();

    public void move() {
        if (isAboveMinCriteria()) {
            forwardPosition += forwardCount;
        }
    }

    public boolean isAboveMinCriteria() {
        int randomValue = new Random().nextInt(10) + 1;
        System.out.println("randomVale : " + randomValue);
        return randomValue >= minCriteria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(monsterName).append(" [").append(monsterType.type).append("] : ");
        IntStream.range(0, forwardCount).forEach(i -> sb.append("-"));
        return sb.toString();
    }
}
