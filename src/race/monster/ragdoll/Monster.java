package race.monster.ragdoll;

import java.util.Random;
import java.lang.StringBuilder;

public class Monster {
    private int moveCount;

    public Monster() {}

    private boolean decideMoveOrStop() {
        boolean decision = false;

        Random random = new Random();
        int randomNum = random.nextInt(10);
        if (randomNum >= 4) {
            decision = true;
        }

        return decision;
    }

    private void move(boolean decision) {
        if (decision) {
            moveCount++;
        }
    }

    void run(int numOfTries) {
        for (int i = 0; i < numOfTries; i++) {
            boolean decision = decideMoveOrStop();
            move(decision);
        }
    }

    public String toString() {
        StringBuilder strBuilder = new StringBuilder(" ");

        for (int i = 0; i < moveCount; i++) {
            strBuilder.append("-");
        }

        return strBuilder.toString();
    }
}
