package MonsterRace;

import java.util.stream.IntStream;
import static MonsterRace.MetaUtils.METAUTILS;

public class Esper implements MoveBehavior {

  private final int DELIMITER = 9;

  @Override
  public int getMoveCount(int roundCount) {
    return IntStream.range(0, roundCount).reduce(0, (old, notUse) ->
        (METAUTILS.randomDice() >= DELIMITER) ? old + esperMoveCount() : old
    );
  }

  private int esperMoveCount() {
    return (int) ((Math.random() * 99) + 1);
  }
}
