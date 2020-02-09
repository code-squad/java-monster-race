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
            this.monsterName = monsterName;
            this.monsterType = MonsterType.valueOfType(monsterType);
            this.minCriteria = this.monsterType.getMinCriteria();
            this.forwardPosition = 0;
    }

    abstract void setForwardCount();

    public void move() {
        if (isAboveMinCriteria()) {
            System.out.println("i'm move!!!");
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
        IntStream.range(0, forwardPosition).forEach(i -> sb.append("-"));
        return sb.toString();
    }
}
