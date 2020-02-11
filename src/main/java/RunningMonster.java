public class RunningMonster extends Monster {

    public RunningMonster(String name) {
        super(name);
        this.type = "달리기";
    }

    @Override
    public int forwardNumber() {
        int randomNumber = this.randomNumber();
        return randomNumber >= 4 ? 1 : 0;
    }

    @Override
    public void move() {
        this.move(forwardNumber());
    }
}
