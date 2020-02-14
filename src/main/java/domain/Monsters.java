package domain;

import domain.monster.Monster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import util.Log;

public class Monsters {

  private Map<String, Monster> monsters;
  private List<Monster> winner;
  private Log log;

  public Monsters() {
    monsters = new HashMap<>();
    winner = new ArrayList<>();
  }

  public Map<String, Monster> getMonsters() {
    return monsters;
  }

  public void printAllMonsters() {
    Iterator iterator = monsters.keySet().iterator();

    while (iterator.hasNext()) {
      Monster monster = monsters.get(iterator.next());
      System.out.println(monster.toString());
    }

  }

  public String getWinner() {
    findWinner();
    StringBuilder sb = new StringBuilder();
    winner.stream()
        .map(x -> x.getName())
        .forEach(s -> sb.append(s+","));
    return sb.toString();
  }

  public void addTryCount(int tryCount) {
    if (monsters.size() < 1) {
      throw new NoSuchElementException("등록된 몬스터가 없어요!");
    }
    Iterator iterator = monsters.keySet().iterator();

    while (iterator.hasNext()) {
      Monster monster = monsters.get(iterator.next());
      monster.attempt(tryCount);
    }
  }

  public void printMonstersForward() {
    if (monsters.size() < 1) {
      throw new NoSuchElementException("등록된 몬스터가 없어요!");
    }
    Iterator iterator = monsters.keySet().iterator();

    while (iterator.hasNext()) {
      Monster monster = monsters.get(iterator.next());
      monster.start();
    }

  }

  public void deleteMonster(String name) {
    monsters.remove(name);
  }

  public void createMonsterLog() {
    if (monsters.size() < 1) {
      throw new NoSuchElementException("등록된 몬스터가 없어요!");
    }
    Iterator iterator = monsters.keySet().iterator();

    log = Log.getInstance();
    int index = 1;
    while (iterator.hasNext()) {
      Monster monster = monsters.get(iterator.next());
      log.write(+index + " : " + monster.toString() + " step : " + monster.getStep());
      index++;
    }
  }


  private void findWinner() {
    String maxKey = Collections.max(monsters.keySet());
    int maxValue = monsters.get(maxKey).getStep();
    Iterator iterator = monsters.keySet().iterator();

    while (iterator.hasNext()) {
      Monster monster = monsters.get(iterator.next());
      if (monster.getStep() == maxValue) {
        winner.add(monster);
      }
    }
  }
}
