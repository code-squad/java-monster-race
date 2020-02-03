package MonsterRace_Step1;

import java.util.List;

public class Output {
    public void resultGame(Main main) {
        Make mk = new Make();
        List<Monster> monsterList = main.getMonsterList();
        System.out.println("<실행 결과>");
        monsterList.stream()
                .forEach(monster -> {
                    int moveStep = monster.getMoveStep();
                    String result = mk.barMaker(moveStep);
                    System.out.println(result);
                });
    }
}
