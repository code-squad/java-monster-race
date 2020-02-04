package race.monster.ragdoll;

import java.util.Random;
import java.lang.StringBuilder;

public class Monster {
    int moveCount;

    Monster() {
        this.moveCount = 0;
    }

    void count() {
        Random random = new Random();
        int randomNumber = random.nextInt(9);

        if (randomNumber >= 4) {
            ++moveCount;
        }
    }
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        for (int index = 0; index < moveCount; index++) {
            strBuilder.append("-");
        }

        return strBuilder.toString();
    }
}
