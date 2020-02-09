import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Monster> monsters;
    private int totalRounds;

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public void setTotalRounds(int totalRounds) {
        this.totalRounds = totalRounds;
    }

    public void start() {
        for (int i = 0; i < totalRounds; i++) {
            monsters.forEach(Monster::moveIfConditionSatisfied);
        }
    }

    public void displayResult() {
        List<Monster> winners = new ArrayList<>();
        for (Monster monster : monsters) {
            System.out.println(monster.resultString());
            updateWinners(winners, monster);
        }
        System.out.println(buildResultStringOf(winners));
    }

    private void updateWinners(List<Monster> winners, Monster monster) {
        int curr = monster.position();
        int max = winners.isEmpty() ? 0 : winners.get(0).position();
        if (curr > max) { winners.clear(); }
        if (curr >= max) { winners.add(monster); }
    }

    private String buildResultStringOf(List<Monster> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append("Winner(s): ");
        for (Monster winner : winners) {
            sb.append(winner.name());
            sb.append(" ");
        }
        return sb.toString();
    }
}
