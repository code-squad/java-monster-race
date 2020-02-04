import java.util.Random;
import java.util.Stack;

public class Monster {
    private static final int FORWARD_RANGE = 9;
    private static final int FORWARD_CONDITION = 4;
    private static final String FORWARD = "-";

    private String step;
    private Random random;
    private Stack<Integer> isForwardStack;

    public Monster(int attemptCount) {
        this.step = "";
        this.random = new Random();
        this.isForwardStack = new Stack<>();

        addIsForwardInt(attemptCount);
        isForward();
    }

    private void isForward() {
        if (isForwardStack.isEmpty()) return;
        if (isForwardStack.pop() >= FORWARD_CONDITION) step += FORWARD;
        isForward();
    }

    private void addIsForwardInt(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            isForwardStack.add(getRandomInt());
        }
    }

    private int getRandomInt() {
        return random.nextInt(FORWARD_RANGE);
    }

    public void run() {
        System.out.println(step);
    }
}

