package com.hsik0225;

public class Monster {
    private String moveLength;

    public String getMoveLength() {
        return moveLength;
    }

    public void move(int numOfMove) {
        this.moveLength = "-".repeat(numOfMove);
    }
}
