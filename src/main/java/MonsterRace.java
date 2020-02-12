import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MonsterRace {

    private int rounds;
    private List<Monster> monsters = new ArrayList<>();
    private Input input = new Input();

    public void ready() {
        System.out.println("<신나는 몬스터 레이스>");
        validateCondition();
    }

    public void start() {
        System.out.println("<레이스 시작!>");
        for(int i = 1; i <= this.rounds; i++) {
            System.out.println("<" + i + "회>");
            updateRound();
            System.out.println();
        }
    }

    public void finish() {
        Monster[] winners = getWinners();
        showWinners(winners);
        input.closeScanner();
    }

    private void validateCondition() {
        this.rounds = input.getRounds();
        int countOfMonsters = input.getCountOfMonsters();
        monsters = input.getParticipants(countOfMonsters);
    }

    private void updateRound() {
        for(Monster monster : monsters) {
            monster.update();
            monster.render();
        }
    }

    private Monster[] getWinners() {
        rankParticipants();
        return listUpCoWinners();
    }

    private void rankParticipants() {
        monsters.sort((preMonster, nextMonster) -> nextMonster.getTraces() - preMonster.getTraces());
    }

    private Monster[] listUpCoWinners() {
        final int WINNER = 0;
        int tracesOfWinner = monsters.get(WINNER).getTraces();
        Stream<Monster> stream = monsters.stream().filter(monster -> tracesOfWinner == monster.getTraces());
        return stream.toArray(Monster[]::new);
    }

    private void showWinners(Monster[] winners) {
        for(Monster winner : winners)
            System.out.println("축하합니다! " + winner + "가 몬스터 레이스에서 우승했습니다!");
    }
}
