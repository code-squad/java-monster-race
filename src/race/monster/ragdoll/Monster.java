package race.monster.ragdoll;

import java.util.Random;
import java.lang.StringBuilder;

public class Monster {
    private int moveCount;

    public Monster() {
        this.moveCount = 0;
    }

    boolean decideMoveOrStop() {
        boolean decision = false;

        Random random = new Random();
        int randomNum = random.nextInt(9);
        if (randomNum >= 4) {
            decision = true;
        }

        return decision;
    }

    void move(boolean decision) {
        if (decision) {
            ++moveCount;
        }
        return;
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
