package domain;

public class Runner extends Monster {
    private final int FORWARD_CONDITION = 4;

    public Runner(String name) {
        super(name);
    }

    @Override
    public void isForward() {
        if (isForwardStack.isEmpty()) return;
        if (isForwardStack.pop() >= FORWARD_CONDITION) step += FORWARD;
        isForward();
    }

}