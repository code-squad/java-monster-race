package MonsterRace;

import java.util.Random;

public class Esper extends Monster {

    Esper(String monsterName, String monsterType) {
        this.monsterName = monsterName;
        this.monsterType = monsterType;
    }

    public void setTotalMonsterMove(int ranNum) {
        Random random = new Random();
        if (ranNum == 9) {
            totalMonsterMove += random.nextInt(100) + 1;
        }
    }
}
