package movestrategy;

public class Run implements MoveStrategy {
    public String name() {
        return "run";
    }

    public int tilesMoved() {
        if (random.nextInt(10) >= 4) {
            return 1;
        }
        return 0;
    }
}
