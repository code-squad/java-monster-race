package com.beemiel.monsterrace;

import java.util.ArrayList;

public class Output {

    public void contentOfGame(ArrayList<Monster> monsters){
        monsters.forEach(System.out::println);
    }

    public void resultOfGame(ArrayList<Monster> winners){
        String winner = "";
        StringBuffer stringBuffer = new StringBuffer(winner);

        for(Monster monster : winners){
            stringBuffer.append(monster.getName()).append(", ");
            winner = stringBuffer.toString();
        }

        System.out.println("축하합니다~ [" + winner + "] 가 레이스에서 우승하였습니다.");
    }

}
