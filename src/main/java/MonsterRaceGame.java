import java.util.Scanner;

public class MonsterRaceGame {

    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler(new Scanner(System.in));
        System.out.println(Message.startLine.getMessage());
        int trialNumber = inputHandler.getTrials();
        int monsterNumber = inputHandler.getMonsterNumber();

        Status status = new Status();
        System.out.println(Message.endLine.getMessage());
        System.out.println(status.showStatus(monsterNumber, trialNumber));
    }
}