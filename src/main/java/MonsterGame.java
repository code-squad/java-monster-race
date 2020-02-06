import java.util.ArrayList;
import java.util.List;

public class MonsterGame {
    int MIN_RANDOM_NUMBER = 0;
    int MAX_RANDOM_NUMBER = 9;

    public int randomNumber() {
        return (int) Math.floor(Math.random() * (MAX_RANDOM_NUMBER + 1)) - MIN_RANDOM_NUMBER;
    }

    public List<List> raceResult(int monsterNumber, int tryNumber) {
        List<List> result = new ArrayList<>();
        for (int i = 0; i < monsterNumber; i++) {
            result.add(singleRaceResult(tryNumber));
        }
        return result;
    }

    private List<Integer> singleRaceResult(int tryNumber) {
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
