package race.monster.ragdoll;

import java.util.Random;
import java.lang.StringBuilder;

public class Monster {
    int moveCount;

    Monster() {
        this.moveCount = 0;
    }

    String decideMoveOrStop() {
        String decision = "STOP";

        Random random = new Random();
        int randomNum = random.nextInt(9);
        if (randomNum >= 4) {
            decision = "MOVE";
        }

        return decision;
    }

    void move(String decision) {
        if (decision.equals("MOVE")) {
            ++moveCount;
        }
        return;
    }

    void run(int numOfTries) {
        for (int i = 0; i < numOfTries; i++) {
            String decision = decideMoveOrStop();
            move(decision);
        }
    }

    public String toString() {
        StringBuilder strBuilder = new StringBuilder(" ");

        for (int i = 0; i < moveCount; i++) {
            strBuilder.append("-");
        }

        System.out.println(strBuilder.toString());
    }
}
