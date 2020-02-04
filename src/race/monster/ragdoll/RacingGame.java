package race.monster.ragdoll;

public class RacingGame {
    private int numOfMonsters;
    private int numOfTries;
    Monster[] monsters = new Monster[numOfMonsters];

    RacingGame(int numOfMonsters, int numOfTries) {
        this.numOfMonsters = numOfMonsters;
        this.numOfTries = numOfTries;
    }

    void createMonsters() {
        for (int i = 0; i < numOfMonsters; i++) {
            monsters[i] = new Monster();
        }
    }

    void runMonsters() {
        for (int i = 0; i < numOfTries; i++) {
            monsters[i].countMove();
        }
    }
}
