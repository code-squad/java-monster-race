package MonsterRace;

public class Esper implements MoveBehavior {

  private final int DELIMITER = 9;
  private int distance = 0;

  @Override
  public int getMoveCount(int roundCount) {
    for (int i = 0; i < roundCount; i++) {
      double randomCount = Math.random() * 10;
      distance += (randomCount >= DELIMITER) ? esperMoveCount() : 0;
    }

    return distance;
  }

  private int esperMoveCount() {
    return (int) ((Math.random() * 97) + 2);
  }
}
