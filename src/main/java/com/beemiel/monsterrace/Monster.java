package com.beemiel.monsterrace;

import java.util.Random;

public class Monster {
    private String name;
    private String type;

    public Monster(){}

    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    private boolean getRandom() {
        Random random = new Random();
        return random.nextInt(10) > 4;
    }

    private void runOrStop() {
        if (getRandom()){
            Output.printRun();
        }
    }

    public void run(int count) {
        while (count > 0) {
            runOrStop();
            count--;
        }
        Output.next();
    }
}
