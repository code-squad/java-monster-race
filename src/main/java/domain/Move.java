package domain;

import java.util.Random;

public interface Move {

    Random random = new Random();

    void attempt(int tryCount);

    void forward();

    void start();
}
