import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Race {
    public int numOfMonster;
    public int numOfRound;
    List<Monster> monsters = new ArrayList<Monster>();

    public void getMonsterNumber() {
        System.out.println("Enter number of monsters");
        Scanner scanner = new Scanner(System.in);
        numOfMonster = scanner.nextInt();
    }

    public void getAttempt() {
        System.out.println("how many times do you want to try");
        Scanner scanner = new Scanner(System.in);
        numOfRound = scanner.nextInt();
    }

    public void makeMonsterList() {
        for(int i = 0; i < numOfMonster; i++) {
            monsters.add(new Monster(i));
        }
    }

    public void raceIntro() {
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
        Race race = new Race();
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
        race.getAttempt();
        race.makeMonsterList();
        race.raceIntro();
        race.startRace();
        race.endRace();
    }
}