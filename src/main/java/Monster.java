import java.util.Random;

public abstract class Monster {
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 0;

    private int position;
    String name;
    String type;

    public Monster(String name) {
        this.position = 0;
        this.name = name;
    }

    public int randomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER + 1 - MIN_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;
    }

    public int randomNumber(int min, int max) {
        return new Random().nextInt(max + 1 - min) + min;
    }

    public int position() {
        return this.position;
    }

    public void move(int n) {
        this.position += n;
    }

    public String name() {
        return this.name;
    }

    abstract void move();

    abstract int forwardNumber();

    @Override
    public String toString() {
        return "Monster{" +
                "position=" + position +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
