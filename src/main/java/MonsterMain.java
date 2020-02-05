import java.io.IOException;

public class MonsterMain {
    public void start() throws IOException {
        InputView inputView = new InputView();
        System.out.println("<재미있는 몬스터 레이스>");

        int monsterNumber = inputView.monsterNumber();
        int tryNumber = inputView.tryNumber();
        inputView.close();

        MonsterGame monsterGame = new MonsterGame(monsterNumber, tryNumber);
        monsterGame.race();

        System.out.println("<실행 결과>");
        monsterGame.consoleFormatGameResult();


    }
}
