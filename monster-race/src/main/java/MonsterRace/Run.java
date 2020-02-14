package MonsterRace;

public class Run extends Monster {

    Run(String monsterName, String monsterType) {
        this.monsterName = monsterName;
        this.monsterType = monsterType;
    }

    public void setTotalMonsterMove(int ranNum) {
        if (ranNum >= 4) {
            totalMonsterMove++;
        }
    }
}
