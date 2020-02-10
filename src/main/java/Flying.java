public class Flying extends Monster {

    public Flying(String monsterName, TYPE type) {
        super(monsterName, type);
    }

    @Override
    public void update() {
        if(isForward())
            this.traces += type.getSpeed();
    }
}
