package MonsterRace;

public class Monster {
    private int monsterID;
    private int totalMove;

    public Monster(int monsterID) {
        this.monsterID = monsterID;
    }

    public int getTotalMove() {
        return totalMove;
    }

    public void setTotalMove(int totalMove) {
        this.totalMove = totalMove;
    }

    public int getMonsterID() {
        return this.monsterID;
    }
}
