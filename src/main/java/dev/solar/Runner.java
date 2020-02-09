package dev.solar;

public class Runner extends Monster {

    public Runner(String monsterName, String monsterType) {
        super(monsterName, monsterType);
        setForwardCount();
    }

    @Override
    void setForwardCount() {
        forwardCount = 1;
    }
}
