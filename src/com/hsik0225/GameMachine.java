package com.hsik0225;

public class GameMachine {
    private Input input;
    private Output output;
    private MonsterRace monsterRace;

    public void startMonsterRace(){
        MonsterRace monsterRace = new MonsterRace();
        input = new Input();
        output = new Output();

        output.startMonsterRace();
        output.askMONSTERS_COUNT();
        output.askCHALLENGE_COUNT();
    }
}
