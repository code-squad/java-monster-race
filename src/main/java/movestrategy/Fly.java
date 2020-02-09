package movestrategy;

public class Fly implements MoveStrategy {
    public String name() {
        return "fly";
    }

    public int tilesMoved() {
        if (random.nextInt(10) >= 6) {
            return 3;
        }
        return 0;
    }
}
