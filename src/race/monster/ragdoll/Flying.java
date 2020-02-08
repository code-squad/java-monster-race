package race.monster.ragdoll;

import java.util.Random;

public class Flying extends Monster {
    private final int FLYING_RANGE = 3;
    private final int CRITERION = 6;

    public Flying(String name, String type) {
        super(name, type);
        rangeAbility = FLYING_RANGE;
    }

    protected boolean decideMoveOrStop() {
        boolean decision = false;

        Random random = new Random();
        int randomNum = random.nextInt(10);

        if (randomNum >= CRITERION) {
            decision = true;
        }

        return decision;
    }

    protected void move(boolean decision) {
        if (decision) {
            moveCount += FLYING_RANGE;
        }
    }
}
