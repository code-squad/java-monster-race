package game;

public class RacingMain {
    public static void main(String[] args) {
        MonsterModel monsterModel = new MonsterModel();
        GameController gameController = new GameController(monsterModel);

        gameController.getMonsterCount();
        gameController.getRoundCount();
        gameController.startRacing();
        gameController.printResult();
    }
}
