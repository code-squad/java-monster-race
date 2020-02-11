public class EsperMonster extends Monster {

    public EsperMonster(String name) {
        super(name);
        this.type = "초능력";
    }

    @Override
    public void move() {
        move(forwardNumber());
    }

    @Override
    public int forwardNumber() {
        int randomNumber = randomNumber();
        return randomNumber == 9 ? randomNumber(1, 99) : 0;
    }
}
