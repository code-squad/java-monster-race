package race.monster.ragdoll;

public class RacingGame {
    private int numOfMonsters;
    private int numOfTries;
    Monster[] monsters;

    RacingGame(int numOfMonsters, int numOfTries) {
        this.numOfMonsters = numOfMonsters;
        this.numOfTries = numOfTries;
        this.monsters = new Monster[numOfMonsters];
    }

    void createMonsters() {
        for (int i = 0; i < numOfMonsters; i++) {
            monsters[i] = new Monster();
        }
    }

    void runMonsters() {
        for (int i = 0; i < numOfMonsters; i++) {
            monsters[i].countMove(numOfTries);
        }
    }

    void printResult() {
        for (int i = 0; i < numOfMonsters; i++) {
            System.out.println(monsters[i].toString());
        }
    }
}
