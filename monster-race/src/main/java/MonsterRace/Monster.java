package MonsterRace;

public abstract class Monster {
    public String monsterName;
    public String monsterType;
    public int totalMonsterMove;


    public int getTotalMove() {
        return totalMonsterMove;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public abstract void setTotalMonsterMove(int ranNum);
}
