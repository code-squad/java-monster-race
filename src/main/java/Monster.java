import java.util.Random;

public class Monster {
    int index;
    String name;
    String vehicle;
    int moves = 0;

    public Monster(int index) {
        this.index = index;
    }

    public String monsterMoves(int numOfRound) {
        String moves = "";
        for(int i = 0; i < numOfRound; i++) {
            Random rand = new Random();
            int rand_int1 = rand.nextInt(10);
            if(rand_int1 >= 4) moves += "-";
        } return moves;
    }
}