package race.monster.ragdoll;

public class Flying extends Monster {
    private final int FLYING_RANGE = 3;
    private final int FLYING_CRITERION = 6;

    public Flying(String name, Types type) {
        super(name, type);
        rangeAbility = FLYING_RANGE;
    }

    protected boolean isMove() {
        boolean decision = false;
        int randomNum = generateRandomNumber(10);

        if (randomNum >= FLYING_CRITERION) {
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
