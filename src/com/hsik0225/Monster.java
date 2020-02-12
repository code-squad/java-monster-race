package com.hsik0225;

import java.util.Random;

public class Monster {
    private String name;
    private String type;
    private int distance;
    private int conditionalValue;
    private int movedDistance;

    public Monster(int conditionalValue, int movedDistance){
        this.conditionalValue = conditionalValue;
        this.movedDistance = movedDistance;
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

    public int getDistance(){
        return this.distance;
    }

    public String move(){
        return "-".repeat(distance);
    }

    private void plusMovedDistance(int randomValue){
        if(randomValue>=conditionalValue){
            distance += movedDistance;
        }
    }

    public void giveRandomValues(int attemptCount){
        Random random = new Random();
        int bound = 10;
        for (int index = 0; index < attemptCount; index++) {
            int randomValue = random.nextInt(bound);
            plusMovedDistance(randomValue);
        }
    }
}
