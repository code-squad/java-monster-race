package dev.solar;

import java.util.stream.IntStream;

enum MonsterType {
    RUN("달리기", 4),
    FLY("비행", 6),
    ESPURR("에스퍼", 9);

    protected final String monsterType;
    protected final int minCriteria;

    MonsterType(String monsterType, int minCriteria) {
        this.monsterType = monsterType;
        this.minCriteria = minCriteria;
    }

    public String getMonsterType() { return monsterType; }
    public int getMinCriteria() { return minCriteria; }
}

public class Monster {
    private String monsterName;
    private String monsterType;
    private int forwardCount;

    public void move() {
        int random = (int) (Math.random() * 10);
        if (random >= 4) {
            forwardCount += random;
        }
    }

    public Monster(String monsterName, String monsterType) {
        this.monsterName = monsterName;
        this.monsterType = monsterType;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, forwardCount).forEach(i -> sb.append("-"));
        return sb.toString();
    }
}
