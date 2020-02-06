import java.util.Random;

public class Monster {
    private String positionString;
    private Random random;

    public Monster() {
        positionString = "";
        random = new Random();
    }

    public void moveIfConditionSatisfied() {
        if (random.nextInt(10) >= 4) { // exclusive bound
            positionString += "-";
        }
    }

    public String getPositionString() {
        return positionString;
    }
}
