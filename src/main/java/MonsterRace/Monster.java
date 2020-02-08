package MonsterRace;

public class Monster {

  private MoveBehavior moveBehavior;
  private String name;
  private String type;
  private String movedDistance;

  public Monster(String name, String type) {
    this.moveBehavior = MonsterType.valueOf(type.trim()).getMoveBehavior();
    this.name = name;
    this.type = type;
  }

  public void move(int roundCount) {
    movedDistance = new String(new char[moveBehavior.getMoveCount(roundCount)]).replace("\0", "-");
  }

  public String getMovedDistance() {
    return movedDistance;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name + " [" + type + " : " + movedDistance.length() + "] : " + movedDistance;
  }
}


