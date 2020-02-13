package MonsterRace;

/**
 * /**
 * P : Print
 * Q : Question
 * E : Error
 */
public enum Text {
  P_START_RACE_MENU_1("<신나는 몬스터 경주>"),
  P_START_RACE_MENU_2("1. 몬스터 정보"),
  P_START_RACE_MENU_3("2. 게임 시작"),
  P_START_RACE_MENU_4("3. 종료"),
  P_START_RACE_MENU_5("원하는 메뉴를 선택해 주세요(1 - 3)"),
  P_START_RACE_MENU(P_START_RACE_MENU_1 + "\n" + P_START_RACE_MENU_2 + "\n"
      + P_START_RACE_MENU_3 + "\n" + P_START_RACE_MENU_4 + "\n" + P_START_RACE_MENU_5),

  P_MONSERT_INFO_MENU_1("<몬스터 정보 메뉴>"),
  P_MONSERT_INFO_MENU_2("1. 전체 몬스터 정보 보기"),
  P_MONSERT_INFO_MENU_3("2. 몬스터 정보 수정"),
  P_MONSERT_INFO_MENU_4("3. 새로운 몬스터 정보 입력"),
  P_MONSERT_INFO_MENU_5("4. 몬스터 정보 삭제"),
  P_MONSERT_INFO_MENU_6("5. 이전 메뉴로"),
  P_MONSERT_INFO_MENU_7("원하는 메뉴를 선택해 주세요 (1 - 5)"),
  P_MONSERT_INFO_MENU_(P_MONSERT_INFO_MENU_1 + "\n" + P_MONSERT_INFO_MENU_2 + "\n" + P_MONSERT_INFO_MENU_3 + "\n" +
      P_MONSERT_INFO_MENU_4 + "\n" + P_MONSERT_INFO_MENU_5 + "\n" + P_MONSERT_INFO_MENU_6 + "\n" + P_MONSERT_INFO_MENU_7),

  Q_ADD_MONSTER_INFO("경주할 몬스터 이름과 종류를 입력하세요(쉼표(,)를 기준으로 구분)."),
  Q_REMOVE_MONSTER_INFO("경주할 몬스터 이름과 종류를 입력하세요(쉼표(,)를 기준으로 구분)."),
  Q_ROUND_COUNT("시도할 회수는 몇 회 인가요?"),

  P_INPUT("### 정상 처리 되었습니다."),
  E_INPUT("### Error : Input Failed"),
  E_CLOSE("### Error : Close Failed"),
  E_FILE("### Error : File Open Failed"),
  E_FILE_WRITE("### Error : File Write Failed"),
  E_MONSTER_INFO_LOAD("### Error : Monster info Load Failed"),

  P_RACE_RESULT1("축하합니다! "),
  P_RACE_RESULT2(" 이(가) 몬스터 레이스에서 우승했습니다."),

  FILE_PAHT("./MonsterInfo.txt");

  private String text;

  Text(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}
