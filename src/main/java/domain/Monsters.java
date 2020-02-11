package domain;

import util.Log;

import java.util.*;

public class Monsters {
    private Map<String, Monster> monsters;
    private Monster winner;
    private Log log;

    public Monsters() {
        monsters = new HashMap<>();
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
        return winner.getName();
    }

    public void addTryCount(int tryCount) {
        if (monsters.size() < 1) throw new NoSuchElementException("등록된 몬스터가 없어요!");
        Iterator iterator = monsters.keySet().iterator();

        while (iterator.hasNext()) {
            Monster monster = monsters.get(iterator.next());
            monster.attempt(tryCount);
        }
    }

    public void printMonstersForward() {
        if (monsters.size() < 1) throw new NoSuchElementException("등록된 몬스터가 없어요!");
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
        if (monsters.size() < 1) throw new NoSuchElementException("등록된 몬스터가 없어요!");
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
        winner = monsters.get(maxKey);
    }

}
