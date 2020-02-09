package dev.solar;

import java.util.Arrays;

public enum MonsterType {
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
