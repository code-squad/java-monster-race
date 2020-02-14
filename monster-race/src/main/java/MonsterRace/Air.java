package MonsterRace;

public class Air extends Monster {

    Air(String monsterName, String monsterType) {
        this.monsterName = monsterName;
        this.monsterType = monsterType;
    }

    public void setTotalMonsterMove(int ranNum) {
        if (ranNum >= 6) {
            totalMonsterMove += 3;
        }
    }
}
