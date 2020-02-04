import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MonsterMain {
    public void start() throws IOException {
        InputView inputView = new InputView();
        System.out.println("<재미있는 몬스터 레이스>");

        int monsterNumber = inputView.monsterNumber();
        int tryNumber = inputView.tryNumber();

        MonsterGame monsterGame = new MonsterGame(monsterNumber, tryNumber);
        monsterGame.race();

        List<List<Integer>> gameResult = monsterGame.gameResult();
        MonsterMain monsterMain = new MonsterMain();
        System.out.println("<실행 결과>");
        monsterMain.printResult(gameResult);
    }

    public String printResult(List<List<Integer>> raceResult) {
        return raceResult.stream()
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
}
