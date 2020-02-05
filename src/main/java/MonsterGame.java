import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MonsterGame {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private int monsterNumber;
    private int tryNumber;
    private List<List<Integer>> gameResult;


    public MonsterGame(int monsterNumber, int tryNumber) {
        this.monsterNumber = monsterNumber;
        this.tryNumber = tryNumber;
    }

    private int randomNumber() {
        return (int) Math.floor(Math.random() * (MAX_RANDOM_NUMBER + 1)) - MIN_RANDOM_NUMBER;
    }

    public List<List<Integer>> race() {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < monsterNumber; i++) {
            result.add(singleRaceResult());
        }

        this.gameResult = result;
        return result;
    }

    public List<List<Integer>> gameResult() {
        return this.gameResult;
    }

    public void consoleFormatGameResult() {
        String gameResult = gameResultFormat();
        System.out.println(gameResult);
    }

    private String gameResultFormat() {
        return gameResult.stream()
                .map(x -> x.stream().reduce(0, Integer::sum))
                .map(this::charTimes)
                .collect(Collectors.joining("\n"));
    }

    private String charTimes(int times) {
        char character = '-';

        String result = "";
        for (int i = 0; i < times; i++) {
            result += character;
        }
        return result;
    }

    private List<Integer> singleRaceResult() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < tryNumber; i++) {
            result.add(forwardNumber(randomNumber()));
        }
        return result;
    }

    private int forwardNumber(int randomResult) {
        return randomResult >= 4 ? 1 : 0;
    }
}
