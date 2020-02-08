package MonsterRace;

import java.util.stream.IntStream;
import static MonsterRace.MetaUtils.METAUTILS;

public class Run implements MoveBehavior {

  private final int DELIMITER = 4;
  private final int MOVE_COUNT = 1;

  @Override
  public int getMoveCount(int roundCount) {
    return IntStream.range(0, roundCount).reduce(0, (old, notUse) ->
        (METAUTILS.randomDice() >= DELIMITER) ? old + MOVE_COUNT : old
    );
  }
}
