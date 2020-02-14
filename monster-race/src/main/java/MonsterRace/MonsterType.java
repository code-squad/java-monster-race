package MonsterRace;

public enum MonsterType {
    RUN("달리기"),
    AIR("비행"),
    ESPER("에스퍼");

    MonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    private final String monsterType;

    public String getmonsterType() {
        return monsterType;
    }

}
