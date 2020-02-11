package com.beemiel.monsterrace;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Output {
    private Message message = new Message();

    public void contentOfGame(ArrayList<Monster> monsters){
        message.gameStart();
        message.result();
        monsters.forEach(System.out::println);
    }

    public void resultOfGame(ArrayList<Monster> winners){
        StringJoiner stringJoiner = new StringJoiner(",","[","]");
        for(Monster monster : winners){
            stringJoiner.add(monster.getName());
        }
        System.out.println("축하합니다~ " + stringJoiner.toString() + " 가 레이스에서 우승하였습니다.");
        message.gameClose();
    }

}
