package com.beemiel.monsterrace;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MonsterType {
    FLY("비행"), RUN("달리기"), ESPER("에스퍼");

    //연관된 데이터
    String type;

    MonsterType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static MonsterType findTypeByInput(String input){
        return Arrays.stream(MonsterType.values())
                .filter(monsterType -> input.equals(monsterType.getType()))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("존재하는 타입이 아닙니다."));
    }

    public Monster makeMonsterByType(String name){
        if(type.equals("비행")){
            System.out.println("비행 타입 생성");
            return new Flying(type,name);
        }

        if(type.equals("달리기")){
            System.out.println("달리기 타입 생성");
            return new Running(type,name);
        }

        System.out.println("에스퍼 타입 생성");
        return new Psychic(type,name);
    }
}
