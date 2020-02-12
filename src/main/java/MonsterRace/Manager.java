package MonsterRace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Manager {
  public InputHandler inputHandler;
  public OutputHandler outputHandler;
  private FileHandler fileHandler;
  private List<Monster> monsters;

  public Manager() {
    this.inputHandler = InputHandler.getInstance();
    this.outputHandler = OutputHandler.getInstance();
    this.fileHandler = FileHandler.getInstance();
    this.monsters = new ArrayList<Monster>();
  }

  public void monsterInfoWork() {
    int input = 0;

    while (input != 5) {
      try {
        System.out.println(Text.P_MONSERT_INFO_MENU_);
        input = inputHandler.getInteger();

        switch (input) {
          case 1:
            printMonsterInfo();
            break;

          case 2:
            throw new Exception();
//            break;

          case 3:
            System.out.println(Text.Q_ADD_MONSTER_INFO);
            if (!addMonster()) throw new Exception();
            System.out.println(Text.P_INPUT);
            break;

          case 4:
            System.out.println(Text.Q_REMOVE_MONSTER_INFO);
            if (!removeMonster()) throw new Exception();
            System.out.println(Text.P_INPUT);
            break;

          case 5:
            break;

          default:
            throw new Exception();
        }
      } catch (Exception e) {
        System.out.println(Text.E_INPUT);
      }
    }

//    try {
//      outputHandler.setFileData(monsters.toString());
//    } catch (Exception e) {
//      System.out.println(Text.E_FILE_WRITE);
//    }
  }

  public void setMonsters() throws Exception {
    String fileData = inputHandler.getFileDate();
    String[] monsterInfoArray = fileData.split("\n");
    Arrays.stream(monsterInfoArray)
        .forEach(monsterInfoString -> addMonster(monsterInfoString));
  }

  public void printRaceResult() {
    monsters.stream().forEach(monster -> {
      System.out.println(monster + " : " + "-".repeat(monster.getDistance()));
    });
  }

  public void moveMonsters(int roundCount) {
    monsters.stream().forEach(monster -> monster.move(roundCount));
  }

  private boolean addMonster() throws Exception {
    String[] monsterInfo = inputHandler.getMonsterInfo();
    return monsters.add(new Monster(monsterInfo[0].trim(), monsterInfo[1].trim()));
  }

  private boolean addMonster(String monsterInfoString) {
    String[] monsterInfo = monsterInfoString.split(",");
    return monsters.add(new Monster(monsterInfo[0].trim(), monsterInfo[1].trim()));
  }

  private boolean removeMonster() throws Exception {
    String[] monsterInfo = inputHandler.getMonsterInfo();
    return monsters.remove(new Monster(monsterInfo[0], monsterInfo[1]));
  }

  private void printMonsterInfo() {
    monsters.stream().forEach(System.out::println);
  }

  public Monster getWinner() {
    Comparator<Monster> comparator = Comparator.comparing(Monster::getDistance);
    return monsters.stream().max(comparator).get();
  }
}
