package game;

import java.util.ArrayList;
import java.util.List;

/**
 * 몬스터의 CRUD를 책임진다.
 */
public class MonsterModel {
    private List<Monster> monsterList = new ArrayList<>();

    // 몬스터를 추가한다.
    public void add() {
        monsterList.add(new Monster());
    }

    // 몬스터 거리를 갱신한다.
    public void updateMonsterDistance() {
        for(Monster monster: monsterList)
            monster.move();
    }

    // 몬스터 리스트를 반환한다.
    public Monster[] getMonsterList() {
        return monsterList.stream().toArray(Monster[]::new);
    }
}
