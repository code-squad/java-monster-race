import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MonsterGame {
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 0;
    private int monsterNumber;
    private int tryNumber;
    private List<Monster> gameResult;


    public MonsterGame(int monsterNumber, int tryNumber) {
        this.monsterNumber = monsterNumber;
        this.tryNumber = tryNumber;
        this.gameResult = new ArrayList<>();
    }

    private int randomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER + 1 - MIN_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;
    }

    public List<Monster> race() {
        for (int i = 0; i < monsterNumber; i++) {
            singleMonsterRace(i);
        }
        return gameResult;
    }

    public List<Monster> gameResult() {
        return this.gameResult;
    }

    public void consoleFormatGameResult() {
        String gameResult = gameResultFormat();
        System.out.println(gameResult);
    }

    private String gameResultFormat() {
        return gameResult.stream().map(monster -> charTimes(monster.position())).collect(Collectors.joining("\n"));
    }

    private String charTimes(int times) {
        char character = '-';

        String result = "";
        for (int i = 0; i < times; i++) {
            result += character;
        }
        return result;
    }

    private Monster singleMonsterRace(int monsterIndex) {
        Monster monster = new Monster();

        for (int i = 0; i < tryNumber; i++) {
            monster.move(forwardNumber(randomNumber()));
        }

        this.gameResult.add(monsterIndex, monster);

        return this.gameResult.get(monsterIndex);
    }

    private int forwardNumber(int randomResult) {
        return randomResult >= 4 ? 1 : 0;
    }
}
