package movestrategy;

public class Espurr implements MoveStrategy {
    public int tilesMoved() {
        if (random.nextInt(10) == 9) {
            return random.nextInt(98) + 2; // 1 < x < 100
        }
        return 0;
    }
}
