package com.beemiel.monsterrace;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Result {

    public void contentOfGame(ArrayList<Monster> monsters){
        monsters.forEach(System.out::println);
    }

    public String appendString(ArrayList<Monster> winners) {
        StringJoiner stringJoiner = new StringJoiner(",","[","]");
        for(Monster monster : winners){
            stringJoiner.add(monster.getName());
        }
        return stringJoiner.toString();
    }

    public void resultOfGame(ArrayList<Monster> winners){
        System.out.println(Message.RESULT);
        System.out.println("축하합니다~ " + appendString(winners) + " 가 레이스에서 우승하였습니다.");
        System.out.println(Message.CLOSE);
    }

}
