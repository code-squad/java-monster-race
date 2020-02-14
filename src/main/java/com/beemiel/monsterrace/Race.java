package com.beemiel.monsterrace;

import java.util.ArrayList;

public class Race {
    private ArrayList<Monster> monsters = new ArrayList<>();

    public void racing() {
        Setting setting = new Setting();
        Result result = new Result();
        Calculator calculator = new Calculator();

        setting.setRace();
        monsters = setting.getMonsters();
        result.contentOfGame(startRacing(setting.getCount()));
        result.resultOfGame(calculator.calculateResults(monsters));
        setting.gameClose();
    }

    public ArrayList<Monster> startRacing(int count) {
        System.out.println(Message.START);
        monsters.forEach(monster -> monster.run(count));
        return monsters;
    }

}
