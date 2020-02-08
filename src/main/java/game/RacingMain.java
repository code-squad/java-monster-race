package game;

public class RacingMain {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        System.out.println("<스릴만점 건전한 몬스터 경주>");
        gameController.init();
        gameController.racingStart();
        gameController.printResult();
    }
}
