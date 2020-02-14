package game.strategy.move;

public class RunnableStrategy implements MovableStrategy{
    private static final int CONDITION = 4;
    private static final int SPEED = 1;

    @Override
    public int move() {
        if(random.nextInt(10) >= CONDITION) {
            return SPEED;
        }
        return 0;
    }
}
