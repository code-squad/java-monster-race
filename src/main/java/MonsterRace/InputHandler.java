package MonsterRace;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHandler {
  private BufferedReader br;

  public InputHandler() {
    this.br = new BufferedReader(new InputStreamReader(System.in));
  }

  public int getInteger() throws Exception {
    return Integer.parseInt(br.readLine());
  }

  public String[] getMonsterInfo() throws Exception {
    String[] monsterInfo = br.readLine().split(",");
    return monsterInfo;
  }

  public void close() throws Exception {
    br.close();
  }
}
