import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MonsterGame {
    private int monsterNumber;
    private int tryNumber;
    private List<Monster> gameResult;


    public MonsterGame(int monsterNumber, int tryNumber) {
        this.monsterNumber = monsterNumber;
        this.tryNumber = tryNumber;
        this.gameResult = new ArrayList<>();
    }

    public void initMonsters(List<Monster> monsters) {
        System.out.println(monsters);
        this.gameResult = monsters;
    }

    public List<Monster> race() {
        for (int i = 0; i < tryNumber; i++) {
            for (Monster monster : gameResult) {
                monster.move();
            }
        }

        return gameResult;
    }

    public void consoleFormatGameResult() {
        String gameResult = formatGameResult();
        System.out.println(gameResult);
    }

    public void consoleWinner() {
        List<Monster> winner = winner();
        System.out.printf("축하합니다! %s가 몬스터 레이스에서 우승하였습니다.", winner.stream().map(monster -> monster.name()).collect(Collectors.joining(",")));
    }

    public List<Monster> winner() {
        List<Monster> winner = new ArrayList<>();

        Collections.sort(gameResult, (o1, o2) -> Integer.compare(o2.position(), o1.position()));
        int winnerPosition = gameResult.get(0).position();
        for (Monster monster : gameResult) {
            if (monster.position() == winnerPosition) {
                winner.add(monster);
                continue;
            }
            break;
        }
        return winner;
    }

    public void addMonster(Monster monster) {
        this.gameResult.add(monster);
    }

    public List<Monster> gameResult() {
        return this.gameResult;
    }

    private String formatGameResult() {
        return gameResult.stream().map(monster -> monster.name + "[" + monster.type + "] : " + formatMonsterLocation(monster.position()))
                .collect(Collectors.joining("\n"));
    }

    private String formatMonsterLocation(int times) {
        char character = '-';
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < times; i++) {
            result.append(character);
        }

        return result.toString();
    }
}
