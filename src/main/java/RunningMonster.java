public class RunningMonster extends Monster {

    public RunningMonster(String name) {
        super(name, MonsterType.RUNNING);
    }

    @Override
    public int forwardNumber() {
        int randomNumber = this.randomNumber();
        return randomNumber >= 4 ? 1 : 0;
    }

    @Override
    public void move() {
        move(forwardNumber());
    }
}
