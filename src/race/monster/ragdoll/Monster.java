package race.monster.ragdoll;

import java.lang.StringBuilder;
import java.util.Random;

enum Types {
    RUNNER("달리기"), FLYING("비행"), ESPER("에스퍼");

    private final String typeName;

    Types(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}

public abstract class Monster {
    private String name;
    private Types type;
    int moveCount;
    int rangeAbility;

    public Monster(String name, Types type) {
        this.name = name;
        this.type = type;
    }

    public Monster(String name, Types type, int rangeAbility) {
        this(name, type);
        this.rangeAbility = rangeAbility;
    }

    abstract boolean isMove();

    abstract void move(boolean decision);

    public String getName() {
        return name;
    }

    int generateRandomNumber(int bound) {
        Random random = new Random();

        return random.nextInt(bound);
    }

    void run(int numOfTries) {
        for (int i = 0; i < numOfTries; i++) {
            boolean decision = isMove();
            move(decision);
        }
    }

    @Override
    public String toString() {
        String monsterProperties = name + " [" + type.getTypeName() + "] : ";
        StringBuilder strBuilder = new StringBuilder(monsterProperties);

        for (int i = 0; i < moveCount; i++) {
            strBuilder.append("-");
        }

        return strBuilder.toString();
    }
}
