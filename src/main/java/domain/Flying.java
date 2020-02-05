package domain;

public class Flying extends Monster {
    private final int FORWARD_CONDITION = 6;
    private final int FLYING_BONUS = 3;

    public Flying(String name) {
        super(name);
    }

    @Override
    public void isForward() {
        if (isForwardStack.isEmpty()) return;
        if (isForwardStack.pop() >= FORWARD_CONDITION)
            step += (FORWARD * FLYING_BONUS);
        isForward();
    }
}