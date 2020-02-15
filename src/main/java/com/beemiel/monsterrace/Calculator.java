package com.beemiel.monsterrace;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Monster> winnerMonsters = new ArrayList<>();

    public ArrayList<Monster> calculateResults(ArrayList<Monster> monsters){
        int highRecord = calculateHighRecord(monsters);

        monsters.forEach(monster -> {
            addWinnerMonster(monster, highRecord);
        });

        return winnerMonsters;
    }

    public void addWinnerMonster(Monster monster, int highRecord){
        if(monster.totalMove.length() >= highRecord){
            winnerMonsters.add(monster);
        }
    }

    public int calculateHighRecord(ArrayList<Monster> monsters){
        int record = 0;

        for(int i=0; i<monsters.size(); i++){
            record = Math.max(record, monsters.get(i).totalMove.length());
        }

        return record;
    }

}
