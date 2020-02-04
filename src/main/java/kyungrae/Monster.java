package kyungrae;

import java.util.Random;

public abstract class Monster {
    final static Random random = new Random();
    final String name;
    final String type;

    int distance = 0;

    Monster(String name, String type){
        this.name = name;
        this.type = type;
    }

    void playARound() {
        int step = move(random.nextInt(10));
        this.distance += step;
    }

    @Override
    public String toString(){
        StringBuilder buffer = new StringBuilder(name + " [" + type + "] : ");
        for(int i=0; i<distance; i++) buffer.append("-");
        return  buffer.toString();
    }

    abstract int move(int random);
}

class Runner extends Monster {
    Runner(String name, String type) {
        super(name, type);
    }

    int move(int random){
        if(random >= 4) return 1;
        return 0;
    }
}

class Flyer extends Monster {
    Flyer(String name, String type) {
        super(name, type);
    }

    int move(int random){
        if(random >= 6) return 3;
        return 0;
    }
}


class Esper extends Monster {
    Esper(String name, String type) {
        super(name, type);
    }

    int move(int random){
        if(random >= 9) return (int)(Math.random()*99) + 1;
        return 0;
    }
}