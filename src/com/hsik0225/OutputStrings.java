package com.hsik0225;

enum OutputStrings {
    GAME_START("<몬스터 레이싱 시작!>"),
    MONSTER_COUNT_QUESTION("몬스터는 모두 몇 명 인가요?"),
    MONSTER_INFO_QUESTION("경주할 몬스터 이름과 종류를 입력하세요 (쉼표(,)를 기준으로 구분)"),
    ATTEMPT_COUNT_QUESTION("시도할 회수는 몇 회 인가요?"),
    RACE_RESULT("<실행 결과>"),
    GAME_EXIT("게임을 종료합니다."),

    INPUT_DIGIT("1~9 사이의 숫자를 입력해주세요");

    private final String message;

    OutputStrings(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
