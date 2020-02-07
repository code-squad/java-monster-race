package com.hsik0225;

public class GameCenter {
    GameMachine gameMachine = new GameMachine();
    User user = new User();

    final int MONSTER_COUNT;
    final int CHALLENGE_COUNT;

    gameMachine.startMonsterRace(MONSTER_COUNT, CHALLENGE_COUNT);
}
