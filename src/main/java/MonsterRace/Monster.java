package MonsterRace;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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
      System.out.println(Text.E_MONSTER_INFO.getText());
    }

    this.name = name;
    this.type = type;
  }

  public void move(int roundCount) {
    movedDistance = (Stream.generate(() -> "-").limit(moveBehavior.getMoveCount(roundCount)))
        .collect(Collectors.joining());
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


