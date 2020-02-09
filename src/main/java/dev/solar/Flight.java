package dev.solar;

public class Flight extends Monster {
    public Flight(String monsterName, String monsterType) {
        super(monsterName, monsterType);
        setForwardCount();
    }

    @Override
    void setForwardCount() {
        forwardCount = 3;
    }
}
