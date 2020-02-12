import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MonsterGame {
    private int monsterNumber;
    private int tryNumber;
    private List<Monster> monsters;

    public MonsterGame(int monsterNumber, int tryNumber) {
        this.monsterNumber = monsterNumber;
        this.tryNumber = tryNumber;
        this.monsters = new ArrayList<>();
    }

    public void initMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public void race() {
        for (int i = 0; i < tryNumber; i++) {
            for (Monster monster : monsters) {
                monster.move();
            }
        }
    }

    public void consoleFormatGameResult() {
        String monsters = formatGameResult();
        System.out.println(monsters);
    }

    public void consoleWinner() {
        List<Monster> winner = createWinner();
        System.out.printf("축하합니다! %s가 몬스터 레이스에서 우승하였습니다.", winner.stream().map(Monster::getName).collect(Collectors.joining(",")));
    }

    public List<Monster> createWinner() {
        List<Monster> winner = new ArrayList<>();

        monsters.sort((o1, o2) -> Integer.compare(o2.getPosition(), o1.getPosition()));
        int winnerPosition = monsters.get(0).getPosition();
        for (Monster monster : monsters) {
            if (monster.getPosition() == winnerPosition) {
                winner.add(monster);
                continue;
            }
            break;
        }
        return winner;
    }

    public List<Monster> getMonsters() {
        return this.monsters;
    }

    private String formatGameResult() {
        return monsters.stream().map(monster -> monster.getName() + "[" + monster.getType().key() + "] : " + formatMonsterLocation(monster.getPosition()))
                .collect(Collectors.joining("\n"));
    }

    private String formatMonsterLocation(int times) {
        char character = '-';
        return String.valueOf(character).repeat(times);
    }
}
