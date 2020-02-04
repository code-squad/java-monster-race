import java.util.ArrayList;
import java.util.List;

public class Playground {
    private List<Monster> monsters;
    private int totalRounds;
    private int currRound;

    public Playground(int numMonsters, int numRounds) {
        monsters = new ArrayList<>();
        for (int i = 0; i < numMonsters; i++) {
            monsters.add(new Monster());
        }
        totalRounds = numRounds;
        currRound = 0;
    }

    public void playGame() {
        while (currRound < totalRounds) {
            playRound();
            currRound++;
        }
    }

    private void playRound() {
        System.out.println(String.format("Round %d", currRound));
        for (Monster monster : monsters) {
            monster.move();
            System.out.println(monster.getPositionString());
        }
    }
}
