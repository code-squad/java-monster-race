package dev.solar;

import java.util.Arrays;
import java.util.stream.IntStream;

enum MonsterType {
    RUN("달리기", 4),
    FLY("비행", 6),
    ESPURR("에스퍼", 9);

    protected final String type;
    protected final int minCriteria;

    MonsterType(String monsterType, int minCriteria) {
        this.type = monsterType;
        this.minCriteria = minCriteria;
    }

    public String getMonsterType() { return type; }
    public int getMinCriteria() { return minCriteria; }

    public static MonsterType valueOfType(String inputMonsterType) {
        return Arrays.stream(MonsterType.values())
                .filter(monsterType -> inputMonsterType.equals(monsterType.type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 타입에 맞지않습니다.",inputMonsterType)));
    }
}

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
