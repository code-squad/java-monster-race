import java.util.Random;

public class Monster {
    private static final int FORWARD_RANGE = 9;
    private static final int FORWARD_CONDITION = 4;
    private static final String FORWARD = "-";

    private String step;
    private Random random;

    public Monster(int attemptCount) {
        this.step = "";
        this.random = new Random();
        forWard(attemptCount);
    }

    private void forWard(int attemptCount) {
        for (int start = 0; start < attemptCount; start++) {
            int isForward = getRandomInt();
            if (isForward >= FORWARD_CONDITION) step += FORWARD;
        }
    }

    private int getRandomInt() {
        return random.nextInt(FORWARD_RANGE);
    }

    public void run() {
        System.out.println(step);
    }
}

