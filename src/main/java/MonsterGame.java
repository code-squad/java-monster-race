import java.util.ArrayList;
import java.util.List;

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
