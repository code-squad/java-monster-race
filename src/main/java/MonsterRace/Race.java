package MonsterRace;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {

  private List<Monster> monsters;
  private InputHandler inputHandler;
  private OutputHandler outputHandler;

  public Race() {
    this.monsters = new ArrayList<Monster>();
    this.inputHandler = new InputHandler();
    this.outputHandler = new OutputHandler();
  }

  public void doRace() {
    try {
      int monsterNum, roundCount;

      System.out.println(Text.P_START_RACE);

      System.out.println(Text.Q_MONSTER_COUNT);
      monsterNum = inputHandler.getInteger();

      System.out.println(Text.Q_MONSTER_INFO);
      setMonsters(monsterNum);

      System.out.println(Text.Q_ROUND_COUNT);
      roundCount = inputHandler.getInteger();

      moveMonsters(roundCount);

      outputHandler.printRaceResult(monsters);
      outputHandler.printWinner(getWinner());

      inputHandler.close();
//      outputHandler.close();
    } catch (Exception e) {
      System.out.println(Text.E_INPUT);
    }
  }

  private void setMonsters(int monsterNum) throws Exception {
    for (int i = 0; i < monsterNum; i++) {
      String[] monsterInfo = inputHandler.getMonsterInfo();
      monsters.add(new Monster(monsterInfo[0], monsterInfo[1]));
    }
  }

  private void moveMonsters(int roundCount) {
    monsters.stream().forEach(monster -> monster.move(roundCount));
  }

  private Monster getWinner() {
    Comparator<Monster> comparator = Comparator.comparing(Monster::getMovedDistance);
    return monsters.stream().max(comparator).get();
  }

  public static void main(String[] args) {
    Race race = new Race();
    race.doRace();
  }
}
