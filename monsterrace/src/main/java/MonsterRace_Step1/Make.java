package MonsterRace_Step1;

import java.util.ArrayList;
import java.util.List;

public class Make {
    public void makeMonster() {
        Main main = new Main();
        List<Monster> monsterList = new ArrayList<>();
        for(int i=0;i<main.getMonsterCnt();i++){
            monsterList.add(new Monster(main.getMoveCnt(),0));
        }
    }

}
