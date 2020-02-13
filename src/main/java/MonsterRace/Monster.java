package MonsterRace;

import java.util.Objects;

public class Monster {

  private MoveBehavior moveBehavior;
  private String name;
  private String type;
  private int distance;

  public Monster(String name, String type) {
    this.moveBehavior = MonsterType.valueOf(type.trim()).getMoveBehavior();
    this.name = name;
    this.type = type;
  }

//  public void move(int roundCount) {
//    movedDistance = new String(new char[moveBehavior.getMoveCount(roundCount)]).replace("\0", "-");
//  }

  public void move(int roundCount) {
    distance = moveBehavior.getMoveCount(roundCount);
  }

  public int getDistance() {
    return distance;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Monster monster = (Monster) o;
    return Objects.equals(name, monster.name) &&
        Objects.equals(type, monster.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type);
  }

  @Override
  public String toString() {
    return name + " [" + type + "]";
//    return name + " [" + type + " : " + movedDistance.length() + "] : " + movedDistance;
  }
}


