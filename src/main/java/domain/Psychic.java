package domain;

public class Psychic extends Monster implements Move {
    private static final int FORWARD_CONDITION = 6;
    private static final int PSYCHIC_BONUS = 100;

    public Psychic(String name) {
        super(name);
    }

    private int randomForward() {
        return random.nextInt(PSYCHIC_BONUS) + FORWARD;
    }

    @Override
    public void attempt(int attemptCount) {
        if (attemptCount == 0) return;
        isForwardStack.add(random.nextInt(FORWARD_RANGE));
        attempt(attemptCount - FORWARD);
    }

    @Override
    public void isForward() {
        if (isForwardStack.isEmpty()) return;
        if (isForwardStack.pop() >= FORWARD_CONDITION)
            step += randomForward();
    }

    @Override
    public void forward() {
        System.out.println(this.toString());
    }
}
