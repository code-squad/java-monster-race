package com.beemiel.monsterrace;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Race {
    private int monster;
    private int count;
    private ArrayList<Monster> monsters = new ArrayList<>();
    private ArrayList<Monster> winnerMonsters = new ArrayList<>();
    private Message message = new Message();
    private Input input = new Input();
    private Output output = new Output();

    public void racing() {
        setting();
        monsters.forEach(monster -> monster.run(count));
        output.contentOfGame(monsters);
        calculateResults();
        output.resultOfGame(winnerMonsters);
        input.close();
    }

    public void setting() {
        while (true){
            try{
                monster = input.inputMonster();
                count = input.inputCount();
                makeMonster();
                break;
            } catch (NumberFormatException | InputMismatchException n){
                System.out.println("숫자를 입력하세요.");
            }
        }
    }

    public void makeMonster(){
        Monster newMonster;

        message.monsterInfo();
        for (int i = 0; i < monster; i++) {
            newMonster = input.inputMonsterInfo();
            monsters.add(newMonster);
        }
    }

    public void calculateResults(){
        int highRecord = calculateHighRecorde();

        monsters.forEach(monster -> {
            addWinnerMonster(monster, highRecord);
        });
    }

    public void addWinnerMonster(Monster monster, int highRecord){
        if(monster.totalMove.length() >= highRecord){
            winnerMonsters.add(monster);
        }
    }

    public int calculateHighRecorde(){
        int record = 0;

        for(int i=0; i<monsters.size(); i++){
            Monster monster = monsters.get(i);
            record = Math.max(record, monster.totalMove.length());
        }

        return record;
    }

}
