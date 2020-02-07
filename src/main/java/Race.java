import java.util.*;

public class Race {
    Scanner scanner;
    int numOfMonster;
    int numOfRound;
    List<Monster> monsters = new ArrayList<Monster>();

    public Race() {
        this.scanner = new Scanner(System.in);
    }

    public void prepare() {
        getMonsterNumber();
        getAttemptNumber();
        makePlayerList();
    }

    public void makePlayerList() {
        for (int i = 0; i < numOfMonster; i++) {
            monsters.add(new Monster());
        }
    }

    public void getMonsterNumber() {
        System.out.println("Enter number of monsters");
        while (!scanner.hasNextInt() || (numOfMonster = scanner.nextInt()) < 0) {
            System.out.println("Enter integer please");
            scanner = new Scanner(System.in);
        }
    }

    public void getAttemptNumber() {
        System.out.println("how many times do you want to play");
        while (!scanner.hasNextInt() || (numOfRound = scanner.nextInt()) < 0) {
            System.out.println("Enter integer please");
            scanner = new Scanner(System.in);
        }
    }

    public void moveOneMonsterOneTme(Monster monster) {
        Random random = new Random();
        int randomInt = random.nextInt(10);
        if (randomInt > 3) {
            monster.oneStepForward();
        }
    }

    public void moveOneMonsterFullTime(Monster monster) {
        for (int i = 0; i < numOfRound; i++) {
            moveOneMonsterOneTme(monster);
        }
    }

    public void moveAllMonstersFullTime() {
        for (Monster monster : monsters) {
            moveOneMonsterFullTime(monster);
        }
    }

    public void start(Race race) {
        Monster monster = new Monster();
        printRaceIntro();
        moveAllMonstersFullTime();
        monster.printAllMonsterLocation(race);
    }

    public void printRaceIntro() {
        System.out.println(numOfMonster + " Monsters are ready to play " + numOfRound + " rounds");
        System.out.println("- Game Start! -");
    }

    public void end() {
        System.out.println("- Game Over - ");
    }

    public static void main(String[] args) {
        Race race = new Race();
        race.prepare();
        race.start(race);
        race.end();
    }
}