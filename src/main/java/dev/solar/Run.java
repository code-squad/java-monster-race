package dev.solar;

public class Run extends Monster {

    public Run(String monsterName, String monsterType) {
        super(monsterName, monsterType);
        setForwardCount();
    }

    @Override
    void setForwardCount() {
        forwardCount = 1;
    }
}
