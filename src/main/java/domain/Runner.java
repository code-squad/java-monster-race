package domain;

public class Runner extends domain.Monster implements Move {
    private static final int FORWARD_CONDITION = 4;

    public Runner(String name) {
        super(name);
    }

    @Override
    public void attempt(int attemptCount) {
        if (attemptCount == 0) return;
        isForwardStack.add(random.nextInt(FORWARD_RANGE));
        attempt(attemptCount - 1);
    }

    @Override
    public void isForward() {
        if (isForwardStack.isEmpty()) return;
        if (isForwardStack.pop() >= FORWARD_CONDITION)
            step += FORWARD;
    }

    @Override
    public void forward() {
        System.out.println(this.toString());
    }

}