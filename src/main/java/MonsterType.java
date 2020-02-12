public enum MonsterType {
    RUNNING("달리기"),
    FLYING("비행"),
    ESPER("에스퍼");

    private String key;

    MonsterType(String key) {
        this.key = key;
    }

    public static MonsterType getByKey(String key) {
        for (MonsterType monsterType : MonsterType.values()) {
            if (monsterType.key.equals(key)) {
                return monsterType;
            }
        }
        return null;
    }

    public String key() {
        return this.key;
    }
}
