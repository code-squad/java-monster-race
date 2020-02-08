package MonsterRace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stadium {
    List<Monster> monsters = new ArrayList<>();

    public Stadium(int monsterCount, int gameCount) {
        playGame(monsterCount, gameCount);
    }

    private void playGame(int monsterCount, int gameCount) {
        makePlayerList(monsterCount);
        for (int i = 0; i < monsters.size(); i++) {
            movingMonster(monsters.get(i), gameCount);
        }
    }

    private void makePlayerList(int monsterCount) {
        for (int i = 0; i < monsterCount; i++) {
            monsters.add(new Monster(i));
        }
    }

    private void movingMonster(Monster monster, int gameCnt) {
        while (gameCnt > 0) {
            moving(monster);
            gameCnt--;
        }
    }

    private void moving(Monster monster) {
        Random random = new Random();
        int ranNum = random.nextInt(10);
        if (ranNum > 4) {
            monster.setTotalMove(monster.getTotalMove() + 1);
        }
    }

    public void printResult() {
        for (int i = 0; i < monsters.size(); i++) {
            System.out.println(makeDash(monsters.get(i)));
        }
    }

    private String makeDash(Monster monster) {
        int totalMove = monster.getTotalMove();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalMove; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
