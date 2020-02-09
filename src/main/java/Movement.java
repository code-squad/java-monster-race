import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Movement {
    private int numOfMonsters;
    private int numOfTries;
    private List<Monster> monsters;

    public Movement(int numOfMonsters, int numOfTries, List<Monster> monsters) {
       this.numOfMonsters = numOfMonsters;
       this.numOfTries = numOfTries;
       this.monsters = monsters;
    }

    public void oneStepForward(Monster monster) {
        monster.moves += 1;
    }

    public void moveOneMonsterOneTme(Monster monster) {
        Random random = new Random();
        int randomInt = random.nextInt(10);
        if (randomInt > 3) {
            oneStepForward(monster);
        }
    }

    public void moveOneMonsterFullTime(Monster monster) {
        for (int i = 0; i < numOfTries; i++) {
            moveOneMonsterOneTme(monster);
        }
    }

    public void moveAllMonstersFullTime(List<Monster> monsters) {
        for (Monster each : monsters) {
            moveOneMonsterFullTime(each);
        }
    }
}
