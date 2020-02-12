package game;

import game.strategy.move.EsperableStrategy;
import game.strategy.move.FlyableStrategy;
import game.strategy.move.MovableStrategy;
import game.strategy.move.RunnableStrategy;

// 몬스터 객체의 속성인 거리를 관리한다.
public class Monster {
    public static final String RUN = "달리기";
    public static final String FLY = "비행";
    public static final String ESPER = "에스퍼";

    private final String name;
    private String type;
    private int distance = 0;
    private MovableStrategy movable = new RunnableStrategy();

    public static Monster of(String[] infos) {
        return new Monster(infos[0], infos[1]);
    }


    public void move() {
        distance += movable.move();
    }

    public int getDistance() {
        return distance;
    }

    public String drawDistance() {
        StringBuilder buffer = new StringBuilder();
        for(int i=0; i<distance; i++) {
            buffer.append("-");
        }
        return buffer.toString();
    }

    @Override
    public String toString() {
        return name + "(" + type + ")";
    }

    private Monster(String name, String type) {
        this.name = name;
        switch (type) {
            case RUN:
                movable = new RunnableStrategy();
                this.type = RUN;
                break;
            case FLY:
                movable = new FlyableStrategy();
                this.type = FLY;
                break;
            case ESPER:
                movable = new EsperableStrategy();
                this.type = ESPER;
                break;
            default:
                this.type = RUN;
                break;
        }
    }
}
