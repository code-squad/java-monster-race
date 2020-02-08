package MonsterRace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

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

      br.close();
    } catch (Exception e) {
      System.out.println(Text.E_INPUT);
    }
  }

  private void setMonsterNum() {
    System.out.println(Text.Q_MONSTER_COUNT);

    try {
      monsterNum = Integer.parseInt(br.readLine());
    } catch (Exception e) {
      System.out.println(Text.E_INPUT);
    }
  }

  private void setMonsters() {
    System.out.println(Text.Q_MONSTER_INFO);

    IntStream.range(0, monsterNum).forEach(i -> {
      try {
        addMonster(br.readLine());
      } catch (IOException e) {
        System.out.println(Text.E_INPUT);
      }
    });
  }

  private void setRoundCount() {
    System.out.println(Text.Q_ROUND_COUNT);

    try {
      roundCount = Integer.parseInt(br.readLine());
    } catch (Exception e) {
      System.out.println(Text.E_INPUT);
    }
  }

  private void addMonster(String input) {
    String[] splitInput = input.replaceAll(" ", "").split(",");
    String name = splitInput[0];
    String type = splitInput[1];
    monsters.add(new Monster(name, type));
    System.out.println();
  }

  public void printResultsOfMatch() {
    for (int i = 0; i < monsters.size(); i++) {
      monsters.get(i).move(roundCount);
      System.out.println(monsters.get(i));
    }

    Comparator<Monster> comparator = Comparator.comparing(Monster::getMovedDistance);
    String winner = monsters.stream().max(comparator).get().getName();

    System.out.println(Text.P_RACE_RESULT1 + winner + Text.P_RACE_RESULT2);
  }

  public static void main(String[] args) {
    Race race = new Race();
    race.startRace();
  }
}
