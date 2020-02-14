package domain;

import domain.monster.Monster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
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
    monsters.keySet()
        .stream()
        .map(x -> monsters.get(x))
        .forEach(System.out::println);
  }

  public String getWinner() {
    findWinner();

    StringBuilder sb = new StringBuilder();
    winner.stream()
        .map(x -> x.getName())
        .forEach(s -> sb.append(s + " "));
    return sb.toString();
  }

  public void addTryCount(int tryCount) {
    if (monsters.size() < 1) {
      throw new NoSuchElementException("등록된 몬스터가 없어요!");
    }
    monsters.keySet()
        .stream()
        .map(x -> monsters.get(x))
        .forEach(x -> x.attempt(tryCount));
  }

  public void printMonstersForward() {
    if (monsters.size() < 1) {
      throw new NoSuchElementException("등록된 몬스터가 없어요!");
    }
    monsters.keySet()
        .stream()
        .map(x -> monsters.get(x))
        .forEach(x -> x.start());
  }

  public void deleteMonster(String name) {
    monsters.remove(name);
  }

  public void createMonsterLog() {
    if (monsters.size() < 1) {
      throw new NoSuchElementException("등록된 몬스터가 없어요!");
    }
    log = Log.getInstance();
    monsters.keySet()
        .stream()
        .map(x -> monsters.get(x))
        .forEach(x -> log.write(x.toString() + " step :" + x.getStep()));
  }


  private void findWinner() {
    int maxValue = findMaxValue().getAsInt();

    monsters.keySet()
        .stream()
        .map(x -> monsters.get(x))
        .filter(x -> x.getStep() == maxValue)
        .forEach(x -> winner.add(x));
  }

  private OptionalInt findMaxValue() {
    return monsters.keySet()
        .stream()
        .mapToInt(x -> monsters.get(x).getStep())
        .max();
  }
}
