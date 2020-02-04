package MonsterRace;

/**
 * The enum TextTemplate
 * 프로그램에 사용될 문자열을 모두 모아두었습니다.
 */
public enum TextTemplate {
    /**
     * P : Print
     * Q : Question
     * E : Error
     * O : Others
     */
    P_START_RACE("<스릴만점 건전한 몬스터 경주>"),
    Q_MONSTER_COUNT("몬스터는 모두 몇 마리인가요?"),
    Q_ROUND_COUNT("시도할 회수는 몇 회 인가요?"),
    Q_MONSTER_NAME_TYPE("경주할 몬스터 이름과 종류를 입력하세요(쉼표(,)를 기준으로 구분)."),
    E_INPUT("### Input Fail : 입력 값이 잘못 되었습니다."),
    P_RACE_RESULT_1("축하합니다! "),
    P_RACE_RESULT_2("가 몬스터 레이스에서 우승했습니다.");

    private String text;

    TextTemplate(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
