package race.monster.ragdoll;

import java.util.Random;

public class Runner extends Monster {
    private final int RUNNER_RANGE = 1;
    private final int CRITERION = 4;

    public Runner(String name, Types type) {
        super(name, type);
        rangeAbility = RUNNER_RANGE;
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
            moveCount += rangeAbility;
        }
    }
}
