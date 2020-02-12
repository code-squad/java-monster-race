package MonsterRace;

import java.io.BufferedWriter;
import java.util.List;

public class OutputHandler {
  private static OutputHandler outputHandler = new OutputHandler();
  private FileHandler fileHandler;
  private BufferedWriter bw;

  private OutputHandler() {
//    this.bw = new BufferedReader(new InputStreamReader(System.in));
    this.fileHandler = FileHandler.getInstance();
  }

  public void printRaceResult(List<Monster> monsters) {
    monsters.stream().forEach(monster -> System.out.println(monster));
  }

  public void printMonsterInfo(List<Monster> monsters) {
    monsters.stream().forEach(System.out::println);
  }

  public void printWinner(Monster winner) {
    System.out.println(Text.P_RACE_RESULT1 + winner.getName() + Text.P_RACE_RESULT2);
  }

  public void setFileData(String fileData) throws Exception {
    fileHandler.setFileData(fileData);
  }

  public static OutputHandler getInstance() {
    return outputHandler;
  }

  public void close() throws Exception {
    bw.close();
  }
}
