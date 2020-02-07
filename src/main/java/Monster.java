import movestrategy.MoveStrategy;

public class Monster {
    private String positionString;
    private MoveStrategy moveStrategy;

    public Monster(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        positionString = "";
    }

    public void moveIfConditionSatisfied() {
        positionString += "-".repeat(moveStrategy.tilesMoved());
    }

    public String getPositionString() {
        return positionString;
    }
}
