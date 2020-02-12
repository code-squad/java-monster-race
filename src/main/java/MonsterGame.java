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
        Integer maxPosition = null;
        List<Monster> res = new ArrayList<>();
        for (Monster monster : monsters) {
            Integer position = monster.getPosition();
            if (maxPosition == null || position.compareTo(maxPosition) > 0) {
                res.clear();
                maxPosition = position;
                res.add(monster);
            } else if (position.compareTo(maxPosition) == 0) {
                res.add(monster);
            }
        }
        return res;
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
