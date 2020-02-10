package movestrategy;

import java.util.Random;

public interface MoveStrategy {
    public static final Random random = new Random();

    public String name();

    public int tilesMoved();
}
