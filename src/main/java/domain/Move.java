package domain;

public interface Move {

    void attempt(int attemptCount);

    void isForward();

    void forward();

    void run();
}
