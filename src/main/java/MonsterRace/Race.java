package MonsterRace;

import java.io.FileNotFoundException;

public class Race {

  private InputHandler inputHandler;
  private Manager manager;

  public Race() {
    this.inputHandler = InputHandler.getInstance();
    this.manager = new Manager();
  }

  public void doRace() {
    try {
      manager.setMonsters();
    } catch (FileNotFoundException e) {
      System.out.println(Text.E_FILE);
    } catch (Exception e) {
      System.out.println(Text.E_MONSTER_INFO_LOAD);
    }

    int input = 0;

    while (input != 3) {
      try {
        System.out.println(Text.P_START_RACE_MENU);
        input = inputHandler.getInteger();

        switch (input) {
          case 1: // 1. 몬스터 정보
            manager.monsterInfoWork();
            break;
          case 2: // 2. 게임 시작
            startRace();
            break;
          case 3: // 3. 종료
            break;
          default:
            throw new Exception();
        }

      } catch (Exception e) {
        System.out.println(Text.E_INPUT);
      }
    }
  }

  private void startRace() throws Exception {
    System.out.println(Text.Q_ROUND_COUNT);
    int roundCount;
    if ((roundCount = inputHandler.getInteger()) < 1)
      throw new Exception();

    manager.moveMonsters(roundCount);
    manager.printRaceResult();
    System.out.println(Text.P_RACE_RESULT1
        + manager.getWinner().getName() + Text.P_RACE_RESULT2 + "\n");
  }

  public static void main(String[] args) {
    Race race = new Race();

    race.doRace();
  }
}
