package com.hsik0225;

enum OutputStrings {
    GAME_START("<몬스터 레이싱 시작!>"),
    MONSTER_COUNT_QUESTION("몬스터는 모두 몇 명 인가요?"),
    MONSTER_INFO_QUESTION("경주할 몬스터 이름과 종류를 입력하세요 (쉼표(,)를 기준으로 구분)"),
    ATTEMPT_COUNT_QUESTION("시도할 회수는 몇 회 인가요?"),
    RACE_RESULT("<실행 결과>"),
    MONSTER_INFO_AND_DISTANCE("%s [%s] : %s\n"),
    WINNER("축하합니다! %s가 몬스터 레이스에서 우승했습니다\n"),
    GAME_EXIT("게임을 종료합니다."),
    INPUT_DIGIT("1이상의 정수를 입력해주세요"),
    INPUT_TYPE("[이름, 타입] 의 형식으로 입력해주세요");

    private final String message;

    OutputStrings(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
