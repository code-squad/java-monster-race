package game;

public class GameMain {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        System.out.println("<신나는 몬스터 레이스>");
        gameController.initialize();
        gameController.race();
        gameController.displayResult();
    }
}
