package dev.solar;

import java.util.Random;

public class Espurr extends Monster {
    public Espurr(String monsterName, String monsterType) {
        super(monsterName, monsterType);
    }

    @Override
    void setForwardCount() {
        Random random = new Random();
        forwardCount = random.nextInt(98) + 2;
    }

    @Override
    public void move() {
        if (isAboveMinCriteria()) {
            setForwardCount();
            forwardPosition += forwardCount;
        }
    }
}
