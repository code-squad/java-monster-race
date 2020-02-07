package domain;

public class Psychic extends Monster {
    private final int FORWARD_CONDITION = 9;
    private final int PSYCHIC_BONUS = 100;
    private int step;

    public Psychic(String name) {
        super(name);
    }

    private int randomForward() {
        return random.nextInt(PSYCHIC_BONUS) + FORWARD;
    }

    public int getStep() {
        return step;
    }

    @Override
    public void isForward() {
        if (steps.isEmpty()) return;
        if (steps.pop() == FORWARD_CONDITION) step += randomForward();
        isForward();
    }

    @Override
    public String toString() {
        return this.name + " " + "[에스퍼]" + " : " + makeStep(step, new StringBuilder());
    }
}
