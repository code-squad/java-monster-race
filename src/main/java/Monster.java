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

    public void moveOneMonsterFullTime(Race race, Monster monster) {
        for (int i = 0; i < race.numOfRound; i++) {
            moveOneMonsterOneTme(monster);
        }
    }

    public void moveAllMonstersFullTime(Race race) {
        for (Monster monster : race.monsters) {
            moveOneMonsterFullTime(race, monster);
        }
    }

    public void printOneMonsterLocation(Monster monster) {
        StringBuilder sb = new StringBuilder();
        for( int i = 0 ; i < monster.moves; i++) {
            sb.append("-");
        }
        System.out.println(monster.index + " : " + sb);
    }

    public void printAllMonsterLocation(Race race) {
        for (Monster m : race.monsters) {
            printOneMonsterLocation(m);
        }
    }
}