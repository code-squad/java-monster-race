package domain;

public class Psychic extends Monster {
    private final int FORWARD_CONDITION = 9;
    private final int PSYCHIC_BONUS = 100;

    public Psychic(String name) {
        super(name);
    }

    private int randomForward() {
        return random.nextInt(PSYCHIC_BONUS) + FORWARD;
    }

    @Override
    public void isForward() {
        if (isForwardStack.isEmpty()) return;
        if (isForwardStack.pop() >= FORWARD_CONDITION) step += randomForward();
        isForward();
    }

}
