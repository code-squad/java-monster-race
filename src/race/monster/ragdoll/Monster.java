package race.monster.ragdoll;

import java.util.Random;
import java.lang.StringBuilder;

public class Monster {
    int moveCount;

    Monster() {
        this.moveCount = 0;
    }

    void countMove(int numOfTries) {
        Random random = new Random();

        for (int i = 0; i < numOfTries; i++) {
            int randomNumber = random.nextInt(9);

            if (randomNumber >= 4) {
                ++moveCount;
            }
        }
    }

    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < moveCount; i++) {
            strBuilder.append("-");
        }

        return strBuilder.toString();
    }
}
