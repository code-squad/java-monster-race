import java.util.ArrayList;
import java.util.List;

public class Playground {
    private List<Monster> monsters;
    private int totalRounds;
    private int currRound;

    public Playground(int numMonsters, int numRounds) {
        initMonsters(numMonsters);
        totalRounds = numRounds;
        currRound = 0;
    }

    public void playGame() {
        while (currRound < totalRounds) {
            playRound();
            currRound++;
        }
    }

    private void initMonsters(int numMonsters) {
        monsters = new ArrayList<>();
        for (int i = 0; i < numMonsters; i++) {
            monsters.add(new Monster());
        }
    }

    private void playRound() {
        System.out.println(String.format("Round %d", currRound));
        for (Monster monster : monsters) {
            monster.moveIfConditionSatisfied();
            System.out.println(monster.getPositionString());
        }
    }
}
