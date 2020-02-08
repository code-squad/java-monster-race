package race.monster.ragdoll;

import java.util.Random;
import java.lang.StringBuilder;

public abstract class Monster {
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

    private String name;
    private Types type;
    int moveCount;
    int rangeAbility;

    public Monster(String name, String typeName) {
        this.name = name;
        this.type = setType(typeName);
    this.moveCount = 0;
    }

    abstract boolean decideMoveOrStop();

    abstract void move(boolean decision);

    private Types setType(String typeName) {
        Types type = Types.valueOf(typeName);

        return type;
    }

    void run(int numOfTries) {
        for (int i = 0; i < numOfTries; i++) {
            boolean decision = decideMoveOrStop();
            move(decision);
        }
    }

    public String toString() {
        StringBuilder strBuilder = new StringBuilder(" ");

        for (int i = 0; i < moveCount; i++) {
            strBuilder.append("-");
        }

        return strBuilder.toString();
    }
}
