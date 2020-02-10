package com.hsik0225;

public class Monster {
    private String name;
    private String type;
    private String moveLength;

    public Monster(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getMoveLength() {
        return moveLength;
    }

    public void move(int numOfMove) {
        this.moveLength = "-".repeat(numOfMove);
    }
}
