package util;

public class Message {

  private final String openGame = "\n<스릴만점 건전한 몬스터 경주> \n1. 몬스터 정보 \n2. 게임 시작\n0. 프로그램 종료";
  private final String monsterMenu = "\n<몬스터 정보 메뉴> \n1. 전체 몬스터 정보 보기\n2. 몬스터 정보 수정\n3. 새로운 몬스터 정보 입력\n4. 몬스트 정보 삭제\n5. 이전 메뉴로";
  private final String modifyMonster = "수정하고 싶은 몬스터의 이름을 입력해주세요 ";
  private final String deleteMonster = "삭제하고 싶은 몬스터의 이름을 입력해주세요 ";
  private final String monsterCount = "몬스터는 모두 몇 마리인가요?";
  private final String errorNoMonsters = "[ERROR] 몬스터 정보를 먼저 입력해주세요";
  private final String modifyType = "수정하고 싶은 몬스터 타입 입력하세요. \n타입 예시 (running, flying, psychic) \n>";
  private final String nameAndType = "경주할 몬스터 이름과 종류를 입력하세요 (쉼표(,)를 기준으로 구분) \n타입 예시 (running, flying, psychic) ";
  private final String tryCount = "시도할 회수는 몇 회 인가요?";
  private final String start = "<경기 시작>";
  private final String close = "<게임을 종료합니다>";

  public Message() {
  }

  public void printNoMonstersError() {
    System.out.println(errorNoMonsters);
  }

  public void printDeleteMonsterMessage() {
    System.out.println(deleteMonster);
  }

  public void printModifyMonsterMessage() {
    System.out.println(modifyMonster);
  }

  public void printModifyTypeMessage() {
    System.out.println(modifyType);
  }

  public void printStartMessage() {
    System.out.println(openGame);
  }

  public void printSubMessage() {
    System.out.println(monsterMenu);
  }

  public void printMonsterCountMessage() {
    System.out.println("\n" + monsterCount);
  }

  public void printNameAndTypeMessage() {
    System.out.println("\n" + nameAndType);
  }

  public void printTryCountMessage() {
    System.out.println("\n" + tryCount);
  }

  public void printResultMessage() {
    System.out.println("\n" + start + "\n");
  }

  public void printCelebrationMessage(String name) {
    System.out.println("\n" + "축하합니다 ! " + name + "이(가) 몬스터 레이스에서 우승했습니다" + "\n");
  }

  public void printCloseMessage() {
    System.out.println(close);
  }

  public void printTypeError() {
    System.out.println("[ERROR] 올바르지 않은 type 입력입니다. (예시 : running, flying, psychic)");
  }

  public void printTryCountError() {
    System.out.println("[ERROR] 시도 횟수는 1이상 입력해주세요.");
  }

  public void printInputError() {
    System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해주세요");
  }

  public void printMonsterCountError() {
    System.out.println("[ERROR] 몬스터 숫자는 2 이상 입력해주세요");
  }

  public void printCheckNameAndTypeError() {
    System.out.println("[ERROR] 중복된 이름입거나, 올바르지 않은 type 입력입니다. (예시 : running, flying, psychic)");
  }

  public void printNotEnoughMonsters() {
    System.out.println("[ERROR] 몬스터 숫자가 2 미만 입니다. 게임을 하기에는 부족해요!");
  }
}
