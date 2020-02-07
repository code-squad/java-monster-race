package com.hsik0225;

import java.util.Scanner;

public class User {
    private Input input;
    private int MONSTER_COUNT;
    private int CHALLENGE_COUNT;

    public User(){
        input = new Input();
    }

    public void setMONSTER_COUNT() {
        this.MONSTER_COUNT = input.input();
    }

    public void setCHALLENGE_COUNT() {
        this.CHALLENGE_COUNT = input.input();
    }
}
