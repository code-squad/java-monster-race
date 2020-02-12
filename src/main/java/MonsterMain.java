import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonsterMain {
    InputView inputView;

    public MonsterMain() {
        this.inputView = new InputView();
    }

    public void start() throws IOException {
        System.out.println("<재미있는 몬스터 레이스>");
        int monsterNumber = monsterNumber();
        int tryNumber = tryNumber();

        MonsterGame monsterGame = new MonsterGame(monsterNumber, tryNumber);
        List<Monster> monsters = createMonsters(monsterNumber);
        monsterGame.initMonsters(monsters);
        inputView.close();

        monsterGame.race();

        System.out.println("<실행 결과>");
        monsterGame.consoleFormatGameResult();
        monsterGame.consoleWinner();
    }

    private int monsterNumber() throws IOException {
        return inputView.monsterNumber();
    }

    private int tryNumber() throws IOException {
        return inputView.tryNumber();
    }

    private List<Monster> createMonsters(int monsterNumber) throws IOException {
        List<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < monsterNumber; i++) {
            monsters.add(createMonster());
        }
        return monsters;
    }

    private Monster createMonster() throws IOException {
        while (true) {
            String[] monsterInfo = inputView.monsterInfo();
            String monsterName = monsterInfo[0];
            MonsterType monsterType = MonsterType.getByKey(monsterInfo[1]);
            if (monsterType == null) {
                continue;
            }
            return MonsterFactory.createMonster(monsterName, monsterType);
        }
    }
}
