package domain;

public class Psychic extends Monster {
    private final int FORWARD_CONDITION = 9;
    private final int PSYCHIC_BONUS = 100;

    public Psychic(String name) {
        super(name);
    }

    private int randomForward() {
        return (random.nextInt(PSYCHIC_BONUS) + 1) + FORWARD;
    }

    @Override
    public void forward() {
        if (steps.isEmpty()) return;
        if (steps.pop() == FORWARD_CONDITION) step += randomForward();
        forward();
    }

    @Override
    public String toString() {
        return this.name + " " + "[에스퍼]" + " : " + makeStep(step);
    }
}
