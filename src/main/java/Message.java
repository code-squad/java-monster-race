public class Message {

    private final String start = "<스릴만점 건전한 몬스터 경주>";
    private final String monsterCount = "몬스터는 모두 몇 마리인가요?";
    private final String attemptCount = "시도할 회수는 몇 회 인가요?";
    private final String result = "<실행 결과>";
    private final String close = "<게임을 종료합니다>";

    public Message() {
    }

    public void startMessage() {
        System.out.println(start);
    }

    public void monsterCountMessage() {
        System.out.println(monsterCount);
    }

    public void attemptCountMessage() {
        System.out.println(attemptCount);
    }

    public void resultMessage() {
        System.out.println(result);
    }

    public void closeMessage() {
        System.out.println(close);
    }
}
