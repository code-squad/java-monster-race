package MonsterRace_Step1;

import java.util.List;

public class Output {
    public void resultGame() {
        Main main = new Main();
        List<Monster> monsterList = main.getMonsterList();
        System.out.println("<실행 결과>");
        monsterList.stream()
                .forEach(monster -> {
                    StringBuffer sb = new StringBuffer();
                    int moveStep = monster.getMoveStep();
                    for(int i=0;i<moveStep;i++){
                        sb.append("-");
                    }
                    System.out.println(sb.toString());
                });
    }
}
