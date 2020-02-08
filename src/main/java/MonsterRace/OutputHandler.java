package MonsterRace;

import java.io.BufferedWriter;
import java.util.List;

public class OutputHandler {
  private BufferedWriter bw;

  public OutputHandler() {
//    this.bw = new BufferedReader(new InputStreamReader(System.in));
  }

  public void printRaceResult(List<Monster> monsters) {
    monsters.stream().forEach(monster -> System.out.println(monster));
  }

  public void printWinner(Monster winner) {
    System.out.println(Text.P_RACE_RESULT1 + winner.getName() + Text.P_RACE_RESULT2);
  }

  public void close() throws Exception {
    bw.close();
  }
}
