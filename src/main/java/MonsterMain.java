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
        List<Monster> monsters = monsters(monsterNumber);
        int tryNumber = tryNumber();

        inputView.close();

        MonsterGame monsterGame = new MonsterGame(monsterNumber, tryNumber);
        monsterGame.initMonsters(monsters);
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

    private List<Monster> monsters(int monsterNumber) throws IOException {
        List<Monster> monsters = new ArrayList<>();

        for (int i = 0; i < monsterNumber; i++) {
            String[] monsterInfo = inputView.monsterInfo();
            monsters.add(monster(monsterInfo[0], monsterInfo[1]));
        }
        return monsters;
    }

    public Monster monster(String name, String type) {
        Monster monster = null;
        if (type.equals("달리기")) {
            monster = new RunningMonster(name);
        }
        if (type.equals("비행")) {
            monster = new FlyingMonster(name);
        }
        if (type.equals("에스퍼")) {
            monster = new EsperMonster(name);
        }
        return monster;
    }
}
