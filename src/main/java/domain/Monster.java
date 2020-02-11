package domain;

import java.util.Random;
import java.util.Stack;

public abstract class Monster implements Move {
    final int FORWARD_RANGE = 10;
    final int FORWARD = 1;

    protected String name;
    protected Stack<Integer> steps;
    protected int step;

    public Monster(String name) {
        this.name = name;
        this.steps = new Stack<>();
    }

    protected String makeStep(int step) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < step; i++) stringBuilder.append('-');
        return stringBuilder.toString();
    }

    public Stack<Integer> getSteps() {
        return steps;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    @Override
    public void attempt(int tryCount) {
        if (tryCount == 0) return;
        steps.add(random.nextInt(FORWARD_RANGE));
        attempt(tryCount - FORWARD);
    }

    public void attempt(Random random, int tryCount) {
        if (tryCount == 0) return;
        steps.add(random.nextInt(FORWARD_RANGE));
        attempt(random, tryCount - FORWARD);
    }


    @Override
    public void start() {
        forward();
        print();
    }

    public void print() {
        System.out.println(this.toString()+" : "+makeStep(step));
    }
}
