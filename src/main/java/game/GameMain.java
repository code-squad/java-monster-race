package game;

public class GameMain {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        gameController.initialize();
        gameController.race();
        gameController.displayResult();
    }
}
