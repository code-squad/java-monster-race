package domain;

public class Running extends Monster {
    private final int FORWARD_CONDITION = 4;

    public Running(String name) {
        super(name);
    }

    @Override
    public void forward() {
        if (steps.isEmpty()) return;
        if (steps.pop() >= FORWARD_CONDITION) step += FORWARD;
        forward();
    }

    @Override
    public String toString() {
        return this.name + " " + "[달리기]" + " : " + makeStep(step);
    }
}