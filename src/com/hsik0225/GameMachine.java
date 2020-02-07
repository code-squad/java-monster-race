package com.hsik0225;

public class GameMachine {
    private Input input;
    private Output output;
    private MonsterRace monsterRace;

    public GameMachine(){
        input = new Input();
        output = new Output();
    }

    public void startMonsterRace(){
        MonsterRace monsterRace = new MonsterRace();
        output.startMonsterRace();
        output.askMONSTERS_COUNT();
        input.input();
        output.askCHALLENGE_COUNT();
        input.input();
    }
}
