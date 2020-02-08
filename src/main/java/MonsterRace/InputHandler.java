package MonsterRace;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHandler {
  private BufferedReader br;

  public InputHandler() {
    this.br = new BufferedReader(new InputStreamReader(System.in));
  }

  public int getMonsterNum() throws Exception {
    System.out.println(Text.Q_MONSTER_COUNT);
    return Integer.parseInt(br.readLine());
  }

  public String[] getMonsterInfo() throws Exception {
    String[] monsterInfo = br.readLine().split(",");
    return monsterInfo;
  }

  public int getRoundCount() throws Exception {
    System.out.println(Text.Q_ROUND_COUNT);
    return Integer.parseInt(br.readLine());
  }

  public void close() throws Exception {
    br.close();
  }
}
