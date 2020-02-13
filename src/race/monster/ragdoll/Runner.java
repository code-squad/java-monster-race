package race.monster.ragdoll;

public class Runner extends Monster {
    private static final int RUNNER_RANGE = 1;
    private static final int RUNNER_CRITERION = 4;

    public Runner(String name, Types type) {
        super(name, type, RUNNER_RANGE);
    }

    protected boolean isMove() {
        boolean decision = false;
        int randomNum = generateRandomNumber(10);

        if (randomNum >= RUNNER_CRITERION) {
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
