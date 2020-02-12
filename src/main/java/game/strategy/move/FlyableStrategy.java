package game.strategy.move;

public class FlyableStrategy implements MovableStrategy {
    private static final int CONDITION = 6;
    private static final int SPEED = 3;

    @Override
    public int move() {
        if(random.nextInt(10) >= CONDITION) {
            return SPEED;
        }
        return 0;
    }
}
