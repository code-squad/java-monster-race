package race.monster.ragdoll;

import java.util.Random;

public class Esper extends Monster {
    private int esperRange;
    private final int CRITERION = 9;

    public Esper(String name, Types type) {
        super(name, type);
    }

    private int decideEsperRange() {
        Random random = new Random();
        int range = random.nextInt(99) + 1;

        return range;
    }

    protected boolean decideMoveOrStop() {
        boolean decision = false;

        Random random = new Random();
        int randomNum = random.nextInt(10);

        if (randomNum == CRITERION) {
            decision = true;
        }

        return decision;
    }

    protected void move(boolean decision) {
        if (decision) {
            esperRange = decideEsperRange();
            moveCount += esperRange;
        }
    }
}
