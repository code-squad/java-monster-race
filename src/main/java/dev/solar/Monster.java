package dev.solar;

import java.util.stream.IntStream;

public class Monster {
    int id;
    int forwardCount = 0;

    public Monster(int id) {
        this.id = id;
    }

    public void setRandomCount() {
        int random = (int) (Math.random()*10);
        if(random >= 4) {
            this.forwardCount += random;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, forwardCount).forEach(i -> sb.append("-"));
        return sb.toString();
    }
}
