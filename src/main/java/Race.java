import java.util.*;

import static java.lang.Integer.parseInt;

public class Race {
    public int numOfMonster;
    public int numOfRound;
    Scanner scanner;
    List<Monster> monsters = new ArrayList<Monster>();

    public Race() {
        this.scanner = new Scanner(System.in);
    }

    public void getMonsterNumber() {
        System.out.println("Enter number of monsters");
        while( !scanner.hasNextInt() || (numOfMonster = scanner.nextInt()) < 0 ) {
                System.out.println("Enter integer please");
                scanner = new Scanner(System.in);
            }
                System.out.println("correct integer");
    }


    public void getAttemptNumber() {
        System.out.println("how many times do you want to try");
        while( !scanner.hasNextInt() || (numOfRound = scanner.nextInt()) < 0 ) {
            System.out.println("Enter integer please");
            scanner = new Scanner(System.in);
        }
            System.out.println("correct integer");
    }

    public void makeMonsterList() {
        for(int i = 0; i < numOfMonster; i++) {
            monsters.add(new Monster(i));
        }
    }

    public void printRaceIntro() {
        Race race = new Race();
        System.out.println(numOfMonster + " Monsters are ready to play " + numOfRound + " rounds");
        for(Monster monster : monsters) {
            System.out.println( "Monster " + monster.index + " has entered the race");
        }
    }
    public void startRace() {
        Race race = new Race();
        System.out.println("<<<<<<< Game Started !>>>>>>>");
        for (int i = 0; i < numOfMonster; i++ ) {
            System.out.println("Monster " + monsters.get(i).index + " : " + race.monsterMoves(numOfRound));
        }
    }
    public String monsterMoves(int numOfRound) {
        String moves = "";
        for(int i = 0; i < numOfRound; i++) {
            Random rand = new Random();
            int rand_int1 = rand.nextInt(10);
            if(rand_int1 >= 4) moves += "-";
        } return moves;
    }

    public void endRace() {
        System.out.println("- Game Over - ");
    }

    public static void main(String[] args) {
        Race race = new Race();
        race.getMonsterNumber();
        race.getAttemptNumber();
        race.makeMonsterList();
        race.printRaceIntro();
        race.startRace();
        race.endRace();
    }
}