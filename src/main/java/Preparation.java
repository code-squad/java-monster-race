import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Preparation {
    Scanner scanner;
    private int numOfMonster;
    private int numOfTries;
    List<Monster> monsters = new ArrayList<Monster>();

    public int getNumOfMonster() {
        return this.numOfMonster;
    }

    public int getNumOfTries() {
        return this.numOfTries;
    }


    public Preparation() {
        this.scanner = new Scanner(System.in);
    }

    public void printIntroMessage() {
        System.out.println("Welcome to Monster Race!");
    }
    
    public void getNumberOfMonsters() {
        System.out.println("Enter number of monsters");
        while (!scanner.hasNextInt() || (numOfMonster = scanner.nextInt()) < 0) {
            System.out.println("Enter integer please");
            scanner = new Scanner(System.in);
        }
    }

    public void getNameAndTypeOfMonsters() {
        System.out.println("Enter each monster's name and type");
        Scanner scanner = new Scanner(System.in);
        String[] slicedInput = scanner.nextLine().split(",");
        String monsterName = slicedInput[0];
        String monsterType = slicedInput[1];
        System.out.println(monsterName + " : " + monsterType);
        monsters.add(new Monster(monsterName, monsterType));
    }

    public void getNumberOfTries() {
        System.out.println("how many times do you want to play");
        while (!scanner.hasNextInt() || (numOfTries = scanner.nextInt()) < 0) {
            System.out.println("Enter integer please");
            scanner = new Scanner(System.in);
        }
    }


    public List<Monster> getPlayerList() {
        return monsters;
    }
}
