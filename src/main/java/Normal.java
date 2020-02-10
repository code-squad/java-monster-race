public class Normal extends Monster {

    public Normal(String monsterName, TYPE type) {
        super(monsterName, type);
    }

    @Override
    public void update() {
        if(isForward())
            this.traces += type.getSpeed();
    }
}
