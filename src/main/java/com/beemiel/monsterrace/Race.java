package com.beemiel.monsterrace;

import java.util.ArrayList;

public class Race {
    private int monster;
    private int count;
    private ArrayList<Monster> monsters = new ArrayList<>();
    private ArrayList<Monster> winnerMonsters = new ArrayList<>();
    private Message message = new Message();
    private Input input = new Input();
    private Output output = new Output();

    //TODO: 더 명확하게 수정
    public void racing() {
        setting();
        message.gameStart();
        message.result();
        monsters.forEach(monster -> monster.run(count));
        output.contentOfGame(monsters);
        calculateResults();
        output.resultOfGame(winnerMonsters);
        message.gameClose();
        input.close();
    }

    private void setting() {
        monster = input.inputMonster();
        makeMonster();
        count = input.inputCount();
    }

    private void makeMonster(){
        Monster newMonster;
        String[] info;
        String name, type;

        message.monsterInfo();

        for (int i = 0; i < monster; i++) {
            info = input.inputMonsterInfo();
            name = info[0];
            type = info[1];
            newMonster = returnMonsterType(name,type);
            monsters.add(newMonster);
        }
    }

    private Monster returnMonsterType(String name, String type){
        if(type.contains("달리기")){
            return new Running(name, type);
        }

        if(type.contains("비행")){
            return new Flying(name, type);
        }

        return new Psychic(name, type);
    }

    public void calculateResults(){
        int highRecord = calculateHighRecorde();

        //TODO: 메세지 클래스는 상수만 두자..(=>근데 이미 많이해서 고치기 귀찮은데...일단...생각은... ) 예외처리해.. 이넘써봐.. 나도 무브를 int 카운트 로 바꿀까..
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
