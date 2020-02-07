import java.util.Random;

public class Monster {
    int index;
    private String name;
    private String vehicle;
    public int moves;

    public Monster() {
    }

    public Monster(int index) {
        this.index = index;
    }

    public int getMoves() {
        return this.moves;
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

    public void moveOneMonsterFullTime(Race raceInput, Monster monster) {
        for (int i = 0; i < raceInput.numOfRound; i++) {
            moveOneMonsterOneTme(monster);
        }
    }

    public void moveAllMonstersFullTime(Race raceInput) {
        for (Monster monster : raceInput.monsters) {
            moveOneMonsterFullTime(raceInput, monster);
        }
    }

    public void printItsLocation(Monster monster) {
        StringBuffer sb = new StringBuffer();
        Race race = new Race();
        for( int i = 0 ; i < monster.moves; i++) {
            sb.append("-");
        }
        System.out.println(monster.index + " : " + sb);
    }
}