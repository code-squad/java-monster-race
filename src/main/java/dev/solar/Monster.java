package dev.solar;

import java.util.stream.IntStream;

public class Monster {
    private int forwardCount = 0;

    public void run() {
        int random = (int) (Math.random() * 10);
        if (random >= 4) {
            forwardCount += random;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, forwardCount).forEach(i -> sb.append("-"));
        return sb.toString();
    }
}
