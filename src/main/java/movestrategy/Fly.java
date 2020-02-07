package movestrategy;

public class Fly implements MoveStrategy {
    public int tilesMoved() {
        if (random.nextInt(10) >= 6) {
            return 3;
        }
        return 0;
    }
}
