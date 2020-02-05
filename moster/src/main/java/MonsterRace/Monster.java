package MonsterRace;

public class Monster {
    private int monsterID;
    private int totMove;

    public Monster(int monsterID) {
        this.monsterID = monsterID;
    }

    public int getTotMove() {
        return totMove;
    }

    public void setTotMove(int totMove) {
        this.totMove = totMove;
    }

    public int getMonsterID() {
        return this.monsterID;
    }
}
