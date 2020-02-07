package race.monster.ragdoll;

import java.util.Random;
import java.lang.StringBuilder;

public abstract class Monster {
    enum Type {
        RUNNER("달리기"), FLYING("비행"), ESPER("에스퍼");

        private final String typeName;

        Type(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }
    }

    private String name;
    private Type type;
    private int moveCount;
    private int rangeAbility;

    public Monster() {
        this.moveCount = 0;
    }

    public abstract boolean decideMoveOrStop();

//    {
//        boolean decision = false;
//
//        Random random = new Random();
//        int randomNum = random.nextInt(10);
//        if (randomNum >= 4) {
//            decision = true;
//        }
//
//        return decision;
//    }

    public abstract void move(boolean decision);

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
