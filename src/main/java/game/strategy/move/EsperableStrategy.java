package game.strategy.move;

public class EsperableStrategy implements MovableStrategy {
    private static final int CONDITION = 9;

    @Override
    public int move() {
        if(random.nextInt(10) >= CONDITION) {
            return random.nextInt(99) + 1;
        }
        return 0;
    }
}
