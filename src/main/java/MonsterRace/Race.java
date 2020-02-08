package MonsterRace;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {

  private int roundCount;
  private int monsterNum;
  private List<Monster> monsters;
  private BufferedReader br;

  public Race() {
    monsters = new ArrayList<Monster>();
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  public void startRace() {
    try {
      System.out.println(Text.P_START_RACE);

      setMonsterNum();
      setMonsters();
      setRoundCount();
      printResultsOfMatch();
      System.out.println(Text.P_RACE_RESULT1 + winnersOfMatch() + Text.P_RACE_RESULT2);

      br.close();
    } catch (Exception e) {
      System.out.println(Text.E_INPUT);
    }
  }

  private void setMonsterNum() throws Exception {
    System.out.println(Text.Q_MONSTER_COUNT);
    monsterNum = Integer.parseInt(br.readLine());
  }

  private void setMonsters() throws Exception {
    System.out.println(Text.Q_MONSTER_INFO);
    for (int i = 0; i < monsterNum; i++) addMonster(br.readLine());
  }

  private void setRoundCount() throws Exception {
    System.out.println(Text.Q_ROUND_COUNT);
    roundCount = Integer.parseInt(br.readLine());
  }

  private void addMonster(String input) {
    String[] splitInput = input.split(",");
    String name = splitInput[0];
    String type = splitInput[1];
    monsters.add(new Monster(name, type));
  }

  private void printResultsOfMatch() {
    for (int i = 0; i < monsters.size(); i++) {
      monsters.get(i).move(roundCount);
      System.out.println(monsters.get(i));
    }
  }

  private String winnersOfMatch() {
    Comparator<Monster> comparator = Comparator.comparing(Monster::getMovedDistance);
    String winner = monsters.stream().max(comparator).get().getName();
    return winner;
  }

  public static void main(String[] args) {
    Race race = new Race();
    race.startRace();
  }
}
