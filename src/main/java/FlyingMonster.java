public class FlyingMonster extends Monster {

    public FlyingMonster(String name) {
        super(name, MonsterType.FLYING);
    }

    @Override
    public void move() {
        move(forwardNumber());
    }

    @Override
    public int forwardNumber() {
        int randomNumber = randomNumber();
        return randomNumber >= 6 ? 3 : 0;
    }
}
