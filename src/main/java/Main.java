import java.util.Random;
import java.util.Scanner;

public class Main {
    private int numOfMonster;
    private int numOfRound;

    public void printMonsters(int numOfMonster) {
        for(int i = 0; i < numOfMonster; i++ ) {
            System.out.println("Monster " + i + " has entered the race");
        }
    }

    public String printMoves(int numOfRound) {
        String moves = "";

        for(int i = 0; i < numOfRound; i++) {
            Random rand = new Random();
            int rand_int1 = rand.nextInt(10);
            if(rand_int1 >= 4) {
                moves += "-";
            }
        } return moves;
    }

    public static void main(String[] args) {
        System.out.println("Enter number of Monsters");
        Scanner scan = new Scanner(System.in);
        int numOfMonster = scan.nextInt();
        System.out.println("How many rounds do you want to play?");
        int numOfRound = scan.nextInt();

        System.out.println(numOfMonster + " Monsters ready to play " + numOfRound + " rounds");
        Main main = new Main();
        main.printMonsters(numOfMonster);
        System.out.println("<<<<<<<Game Start !>>>>>>>");
        for (int i = 0; i < numOfMonster; i++) {
            System.out.println("Monster" + i + main.printMoves(numOfRound));
        }
    }
}
