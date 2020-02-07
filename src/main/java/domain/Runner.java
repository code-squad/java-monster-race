package domain;

public class Runner extends Monster {
    private final int FORWARD_CONDITION = 4;
    private int step;

    public Runner(String name) {
        super(name);
    }

    public int getStep() {
        return step;
    }

    @Override
    public void isForward() {
        if (steps.isEmpty()) return;
        if (steps.pop() >= FORWARD_CONDITION) step += FORWARD;
        isForward();
    }

    @Override
    public String toString() {
        return this.name + " " + "[달리기]" + " : " + makeStep(step, new StringBuilder());
    }
}