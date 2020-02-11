package race.monster.ragdoll;

public class Esper extends Monster {
    private int esperRange;
    private final int ESPER_CRITERION = 9;

    public Esper(String name, Types type) {
        super(name, type);
    }

    private int decideRange() {
        return generateRandomNumber(99) + 1;
    }

    protected boolean isMove() {
        boolean decision = false;
        int randomNum = generateRandomNumber(10);

        if (randomNum == ESPER_CRITERION) {
            decision = true;
        }

        return decision;
    }

    protected void move(boolean decision) {
        if (decision) {
            esperRange = decideRange();
            moveCount += esperRange;
        }
    }
}
