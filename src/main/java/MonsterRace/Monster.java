package MonsterRace;

public class Monster {

  private MoveBehavior moveBehavior;
  private String name;
  private String type;
  private String movedDistance;

  public Monster(String name, String type) {
    try {
      switch (type) {
        case "달리기":
          this.moveBehavior = new Run();
          break;
        case "비행":
          this.moveBehavior = new Fly();
          break;
        case "에스퍼":
          this.moveBehavior = new Esper();
          break;
        default:
          throw new Exception();
      }
    } catch (Exception e) {
      System.out.println(Text.E_MONSTER_INFO);
    }

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


