import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public int numOfMonster = 0;
    public int numOfRound = 0;
    List<Monster> monsters = new ArrayList<Monster>();

    public void getUserInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of Monsters");
        numOfMonster = scan.nextInt();

        for(int i = 0; i < numOfMonster; i++) {
            monsters.add(new Monster(i));
        }

        System.out.println("How many rounds do you want to play?");
        numOfRound = scan.nextInt();
    }

    public void raceIntro() {
        Main main = new Main();
        System.out.println(numOfMonster + " Monsters are ready to play " + numOfRound + " rounds");
        for(Monster monster : monsters) {
            System.out.println( "Monster " + monster.index + " has entered the race");
        }
    }
    public void startRace() {
        Main main = new Main();
        System.out.println("<<<<<<< Game Started !>>>>>>>");
        for (int i = 0; i < numOfMonster; i++ ) {
            System.out.println("Monster " + monsters.get(i).index + " : " + main.monsterMoves(numOfRound));
        }
    }
    public String monsterMoves(int numOfRound) {
        Main main = new Main();
        String moves = "";
        for(int i = 0; i < numOfRound; i++) {
            Random rand = new Random();
            int rand_int1 = rand.nextInt(10);
            if(rand_int1 >= 4) moves += "-";
        } return moves;
    }

    public void endRace() {
        System.out.println("- Game Over -");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.getUserInput();
        main.raceIntro();
        main.startRace();
        main.endRace();
    }
}
