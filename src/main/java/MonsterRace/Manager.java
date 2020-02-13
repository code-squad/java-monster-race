package MonsterRace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Manager {
  public InputHandler inputHandler;
  public OutputHandler outputHandler;
  private List<Monster> monsters;

  public Manager() {
    this.inputHandler = InputHandler.getInstance();
    this.outputHandler = OutputHandler.getInstance();
    this.monsters = new ArrayList<Monster>();
  }

  public void monsterInfoWork() {
    int input = 0;

    while (input != 5) {
      try {
        System.out.println(Text.P_MONSERT_INFO_MENU_);
        input = inputHandler.getInteger();

        switch (input) {
          case 1: // 1. 전체 몬스터 정보 보기
            printMonsterInfo();
            break;

          case 2: // 2. 몬스터 정보 , 구현되지 않음
            throw new Exception();
//            break;

          case 3: // 3. 새로운 몬스터 정보 입력
            System.out.println(Text.Q_ADD_MONSTER_INFO);
            if (!addMonster()) throw new Exception();
            System.out.println(Text.P_INPUT + "\n");
            break;

          case 4: // 4. 몬스터 정보 삭제
            System.out.println(Text.Q_REMOVE_MONSTER_INFO);
            if (!removeMonster()) throw new Exception();
            System.out.println(Text.P_INPUT + "\n");
            break;

          case 5: // 5. 이전 메뉴로
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

  private void printMonsterInfo() {
    monsters.stream().forEach(System.out::println);
    System.out.println();
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

  public Monster getWinner() {
    Comparator<Monster> comparator = Comparator.comparing(Monster::getDistance);
    return monsters.stream().max(comparator).get();
  }
}
