package MonsterRace;

/**
 * /**
 * P : Print
 * Q : Question
 * E : Error
 */
public enum Text {
  P_START_RACE("<스릴만점 건전한 몬스터 경주>")
  , Q_MONSTER_COUNT("몬스터는 모두 몇 마리인가요?")
  , Q_MONSTER_INFO("경주할 몬스터 이름과 종류를 입력하세요(쉼표(,)를 기준으로 구분).")
  , Q_ROUND_COUNT("시도할 회수는 몇 회 인가요?")
  , E_INPUT("### Input Fail : 잘못된 입력 값 입니다.")
  , E_MONSTER_INFO("### Monster info Fail : Monster 의 정보가 잘못 되었습니다.")
  , P_RACE_RESULT1("축하합니다! ")
  , P_RACE_RESULT2(" 이(가) 몬스터 레이스에서 우승했습니다.");

  private String text;

  Text(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}
