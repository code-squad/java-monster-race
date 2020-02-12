public class MonsterFactory {

    private MonsterFactory() {
    }

    ;

    public static Monster createMonster(String name, MonsterType type) {
        switch (type) {
            case RUNNING:
                return new RunningMonster(name);
            case FLYING:
                return new FlyingMonster(name);
            case ESPER:
                return new EsperMonster(name);
        }
        return null;
    }
}
