import java.util.List;

public class Race {
    private int currRound;
    private List<Monster> monsters;
    private int totalRounds;

    public Race() {
        currRound = 0;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public void setTotalRounds(int totalRounds) {
        this.totalRounds = totalRounds;
    }

    public void start() {
        while (currRound < totalRounds) {
            playRound();
            currRound++;
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
