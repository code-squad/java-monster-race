package race.monster.ragdoll;

public class GameMachine {
    public static void main(String[] args) {
        RacingGame newGame = new RacingGame();

        newGame.getNumOfMonster();
        newGame.getNumOfTries();
        newGame.createMonster();
        newGame.startGame();
        newGame.printResult();
    }
}
