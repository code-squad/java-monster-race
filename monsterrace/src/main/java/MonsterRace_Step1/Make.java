package MonsterRace_Step1;

import java.util.List;
import java.util.Random;

public class Make {
    public void makeMonster() {
        Main main = new Main();
        List<Monster> monsterList = main.getMonsterList();
        for(int i=0;i<main.getMonsterCnt();i++){
            monsterList.add(makeMove(main.getMoveCnt()));
        }
        main.setMonsterList(monsterList);
    }

    public Monster makeMove(int moveCnt) {
        Random random = new Random();
        int moveStep = 0;
        while(moveCnt > 0){
            int oneStep = random.nextInt(10);
            if(oneStep > 4){
                moveStep++;
            }
            moveCnt--;
        }
        return new Monster(moveStep);
    }

}
