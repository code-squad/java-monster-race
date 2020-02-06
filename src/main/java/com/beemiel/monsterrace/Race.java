package com.beemiel.monsterrace;

import java.util.ArrayList;

public class Race {
    private int monster;
    private int count;
    private ArrayList<Monster> monsters = new ArrayList<>();
    Output output = new Output();

    public void racing() {
        setting();
        output.result();
        monsters.forEach(monster -> monster.run(count));
        output.gameClose();
    }

    private void setting() {
        Input input = new Input();
        monster = input.inputMonster();
        count = input.inputCount();
        input.close();
        makeMonster();
    }

    private void makeMonster(){
        for (int i = 0; i < monster; i++) {
            monsters.add(new Monster());
        }
    }
}
