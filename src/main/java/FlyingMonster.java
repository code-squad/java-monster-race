public class FlyingMonster extends Monster {

    public FlyingMonster(String name) {
        super(name);
        this.type = "비행";
    }

    @Override
    public void move() {
        this.move(forwardNumber());
    }

    @Override
    public int forwardNumber() {
        int randomNumber = randomNumber();
        return randomNumber >= 6 ? 3 : 0;
    }
}
