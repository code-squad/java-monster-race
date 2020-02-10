package util;

public class Message {

    private final String openGame = "<스릴만점 건전한 몬스터 경주>";
    private final String monsterCount = "몬스터는 모두 몇 마리인가요?";
    private final String nameAndType = "경주할 몬스터 이름과 종류를 입력하세요 (쉼표(,)를 기준으로 구분) \n타입 예시 (running, flying, psychic) ";
    private final String attemptCount = "시도할 회수는 몇 회 인가요?";
    private final String start = "<경기 시작>";
    private final String close = "<게임을 종료합니다>";

    public Message() {
    }

    public void startMessage() {
        System.out.println(openGame);
    }

    public void monsterCountMessage() {
        System.out.println("\n" + monsterCount);
    }

    public void nameAndTypeMessage() {
        System.out.println("\n" + nameAndType);
    }

    public void attemptCountMessage() {
        System.out.println("\n" + attemptCount);
    }

    public void resultMessage() {
        System.out.println("\n" + start + "\n");
    }

    public void winnerMessage(String name) {
        System.out.println("\n" + "축하합니다 ! " + name + "가 몬스터 레이스에서 우승했습니다" + "\n");
    }

    public void closeMessage() {
        System.out.println(close);
    }
}
