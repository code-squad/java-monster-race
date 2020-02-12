import java.util.Scanner;

public class MonsterRaceGame {

    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler(new Scanner(System.in));
        System.out.println(Message.startLine.getMessage());
        int trials = inputHandler.getTrials();
        int monsters = inputHandler.getMonsterNumber();

        Location location = new Location(trials, monsters);
        location.showStatus();

        System.out.println(Message.endLine.getMessage());
    }
}