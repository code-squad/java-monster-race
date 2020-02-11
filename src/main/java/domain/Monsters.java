package domain;

import java.util.*;

public class Monsters {
    private Map<String, Monster> monsters;
    private Monster winner;

    public Monsters() {
        monsters = new HashMap<>();
    }

    public Map<String, Monster> getMonsters() {
        return monsters;
    }

    public Monster getWinner() {
        findWinner();
        return winner;
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

    private void findWinner() {
        String maxKey = Collections.max(monsters.keySet());
        winner = monsters.get(maxKey);
    }

}
