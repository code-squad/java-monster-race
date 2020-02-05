package MonsterRace;

public class Fly implements MoveBehavior {

  private final int DELIMITER = 4;
  private final int MOVE_COUNT = 3;
  private int distance = 0;

  @Override
  public int getMoveCount(int roundCount) {
    for (int i = 0; i < roundCount; i++) {
      double randomCount = Math.random() * 10;
      distance += (randomCount >= DELIMITER) ? MOVE_COUNT : 0;
    }

    return distance;
  }
}
