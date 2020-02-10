package com.hsik0225;

enum OutputStrings {
    START_MONSTER_RACING("<몬스터 레이싱 시작!>"),
    ASK_MONSTER_COUNT("몬스터는 모두 몇 마리인가요?"),
    ASK_ATTEMPT_COUNT("시도할 회수는 몇 회 인가요?"),
    GAME_EXIT_MESSAGE("게임을 종료합니다.");

    private final String message;

    OutputStrings(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
