package MonsterRace;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHandler {
  private static InputHandler inputHandler = new InputHandler();
  private BufferedReader br;

  private FileHandler fileHandler;

  private InputHandler() {
    this.br = new BufferedReader(new InputStreamReader(System.in));
    this.fileHandler = FileHandler.getInstance();
  }

  public int getInteger() throws Exception {
    return Integer.parseInt(br.readLine());
  }

  public String[] getMonsterInfo() throws Exception {
    String[] monsterInfo = br.readLine().split(",");
    return monsterInfo;
  }

  public static InputHandler getInstance() {
    return inputHandler;
  }

  public String getFileDate() throws Exception {
//    String pathName = Text.FILE_PAHT.toString();
//    fileHandler.connectFile(pathName);
    return fileHandler.getFileData();
  }

  public void close() throws Exception {
    br.close();
  }
}
