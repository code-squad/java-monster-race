package kyungrae;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.getGameManager();

        gameManager.build();
        gameManager.start();
        gameManager.printResult();
    }
}
