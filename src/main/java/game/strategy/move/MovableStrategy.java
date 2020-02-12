package game.strategy.move;

import java.util.Random;

public interface MovableStrategy {
    Random random = new Random();

    int move();
}
