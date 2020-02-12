import java.util.Random;

public abstract class Monster {
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 0;

    private int position = 0;
    private String name;
    private MonsterType type;

    public Monster() {
    }

    public Monster(String name, MonsterType type) {
        this.name = name;
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonsterType getType() {
        return type;
    }

    public void setType(MonsterType type) {
        this.type = type;
    }

    public int randomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER + 1 - MIN_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;
    }

    public int randomNumber(int min, int max) {
        return new Random().nextInt(max + 1 - min) + min;
    }

    public void move(int n) {
        this.position += n;
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
