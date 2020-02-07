import java.util.*;

public class Race {
    int numOfMonster;
    int numOfRound;
    Scanner scanner;
    List<Monster> monsters = new ArrayList<Monster>();

    public Race() {
        this.scanner = new Scanner(System.in);
    }

    public void prepare() {
        getMonsterNumber();
        getAttemptNumber();
        makePlayerList();
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

    public void makePlayerList() {
        for (int i = 0; i < numOfMonster; i++) {
            monsters.add(new Monster(i));
        }
    }

    public void start() {
        Monster monster = new Monster();
        printRaceIntro();
    }

    public void printRaceIntro() {
        System.out.println(numOfMonster + " Monsters are ready to play " + numOfRound + " rounds");
        for (Monster monster : monsters) {
            System.out.println("Monster " + monster.index + " has entered the race");
        }
        System.out.println("- Game Start! -");
    }

    public void end() {
        System.out.println("- Game Over - ");
        System.out.println("Winner is ~~~~~");
    }

    public static void main(String[] args) {
        Race race = new Race();
        Monster monster = new Monster();
        race.prepare();
        race.start();
        monster.moveAllMonstersFullTime(race);
        monster.printAllMonsterLocation(race);
    }
}