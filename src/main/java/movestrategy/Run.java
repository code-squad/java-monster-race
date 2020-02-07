package movestrategy;

public class Run implements MoveStrategy {
    public int tilesMoved() {
        if (random.nextInt(10) >= 4) {
            return 1;
        }
        return 0;
    }
}
