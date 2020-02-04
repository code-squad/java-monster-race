package MonsterRace;

public enum MonsterEnum {
    RUN("달리기"),
    FLY("비행"),
    ESPER("에스퍼");

    private String text;

    MonsterEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
