import movestrategy.MoveStrategy;

public class Monster {
    private String name;
    private MoveStrategy moveStrategy;
    private int position;

    public Monster(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
        position = 0;
    }

    public void moveIfConditionSatisfied() {
        position += moveStrategy.tilesMoved();
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public String resultString() {
        return String.format("%s [%s] : %s",
                name,
                moveStrategy.name(),
                "-".repeat(position));
    }
}
