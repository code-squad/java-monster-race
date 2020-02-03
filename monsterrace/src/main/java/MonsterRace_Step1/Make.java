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
        int moveStep = 0;
        while(moveCnt > 0){
            moveStep += makeOneStep();
            moveCnt--;
        }
        return new Monster(moveStep);
    }

    public int makeOneStep() {
        Random random = new Random();
        int oneStep = random.nextInt(10);
        if(oneStep > 4){
            return 1;
        }
        return 0;
    }

    public String barMaker(int moveStep){
        String result = "";
        StringBuffer sb = new StringBuffer();
        while(moveStep > 0){
            sb.append("-");
            moveStep --;
        }
        result = sb.toString();
        return result;
    }
}
