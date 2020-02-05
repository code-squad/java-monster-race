package MonsterRace;

/**
 * The enum TextTemplate
 * 프로그램에 사용될 문자열을 모두 모아두었습니다.
 */
public enum TextTemplate {
    START_RACE("<스릴만점 건전한 몬스터 경주>"),
    Q_MONSTER_COUNT("몬스터는 모두 몇 마리인가요?"),
    Q_ROUND_COUNT("시도할 회수는 몇 회 인가요?"),
    INPUT_ERR("### Input Fail : 각 입력 값은 Integer 의 범위에 있어야 합니다.");

    private String text;

    TextTemplate(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
