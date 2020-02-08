import movestrategy.MoveStrategy;

public class Monster {
    private String name;
    private MoveStrategy moveStrategy;
    private String positionString;

    public Monster(String name, MoveStrategy moveStrategy) {
        this.name = name;
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
