package dev.solar;

public class Run extends Monster {

    public Run(String monsterName, String monsterType) {
        super(monsterName, monsterType);
        setForwardCount();
    }

    @Override
    public void setForwardCount() {
        forwardCount = 1;
    }
}
