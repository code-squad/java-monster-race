import java.io.IOException;
import java.util.List;

public class MonsterMain {
    public void start() throws IOException {
        InputView inputView = new InputView();
        System.out.println("<재미있는 몬스터 레이스>");
        int monsterNumber = inputView.monsterNumber();
        int tryNumber = inputView.tryNumber();
        MonsterGame monsterGame = new MonsterGame();
        List<List> raceResult = monsterGame.raceResult(monsterNumber, tryNumber);
        MonsterMain monsterMain = new MonsterMain();
        System.out.println("<실행 결과>");
        monsterMain.printResult(raceResult);
    }

    public void printResult(List<List> raceResult) {
        char positionChar = '-';
        for (int i = 0; i < raceResult.size(); i++) {
            List<Integer> integers = raceResult.get(i);
            int sum = integers.stream().reduce(0, (a, b) -> a + b);
            System.out.println(charTimes(positionChar, sum));
        }
    }

    public String charTimes(char str, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }
}
