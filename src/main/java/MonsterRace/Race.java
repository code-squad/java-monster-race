package MonsterRace;

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
    } catch (Exception e) {
      System.out.println(Text.E_FILE);
    }

    int input = 0;

    while (input != 3) {
      try {
        int roundCount;

        System.out.println(Text.P_START_RACE_MENU);
        input = inputHandler.getInteger();

        switch (input) {
          case 1:
            manager.monsterInfoWork();
            break;

          case 2:
            System.out.println(Text.Q_ROUND_COUNT);
            roundCount = inputHandler.getInteger();
            if (roundCount < 1) throw new Exception();

            manager.moveMonsters(roundCount);
            manager.printRaceResult();
            System.out.println(Text.P_RACE_RESULT1
                + manager.getWinner().getName() + Text.P_RACE_RESULT2);
            break;

          case 3:
            break;

          default:
            throw new Exception();
        }

      } catch (Exception e) {
        System.out.println(Text.E_INPUT);
      }
    }
  }

  public static void main(String[] args) {
    Race race = new Race();

    race.doRace();
  }
}
