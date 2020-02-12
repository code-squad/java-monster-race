enum Message {
    startLine("<스릴만점 건전한 몬스터 경주>"),
    monsterNumber("몬스터는 모두 몇 마리인가요?"),
    trialNumber("시도할 회수는 몇 회 인가요?"),
    endLine("<실행 결과>");

    final private String message;

    public String getMessage() {
        return message;
    }
    Message(String message) {
        this.message = message;
    }
}