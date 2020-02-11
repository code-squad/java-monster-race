package domain;

import java.util.Random;

public class Psychic extends Monster {
    private final int FORWARD_CONDITION = 9;
    private final int PSYCHIC_BONUS = 100;

    public Psychic(String name) {
        super(name);
    }


    private int randomForward() {
        return (random.nextInt(PSYCHIC_BONUS) + 1);
    }

    private int randomForward(Random random) {
        return (random.nextInt(PSYCHIC_BONUS) + 1);
    }


    @Override
    public void forward() {
        if (steps.isEmpty()) return;
        if (steps.pop() == FORWARD_CONDITION) step += randomForward();
        forward();
    }

    public void forward(Random random) {
        if (steps.isEmpty()) return;
        if (steps.pop() == FORWARD_CONDITION) step += randomForward(random);
        forward(random);
    }


    @Override
    public String toString() {
        return this.name + " " + "[에스퍼]";
    }
}
