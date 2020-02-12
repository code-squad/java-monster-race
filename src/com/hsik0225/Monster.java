package com.hsik0225;

public class Monster {
    private String name;
    private String type;
    private int moveCount;
    private int value_can_move;
    private int plusValue;

    public Monster(int value_can_move, int plusValue){
        this.value_can_move = value_can_move;
        this.plusValue = plusValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getMoveCount(){
        return this.moveCount;
    }

    public String move(){
        return "-".repeat(moveCount);
    }

    public void plusMoveCount(int randomValue){
        if(randomValue>=value_can_move){
            moveCount += plusValue;
        }
    }
}
