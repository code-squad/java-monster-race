package domain;

import java.util.Stack;

public abstract class Monster implements Move {
    final int FORWARD_RANGE = 10;
    final int FORWARD = 1;

    String name;
    Stack<Integer> steps;
    int step;

    public Monster(String name) {
        this.name = name;
        this.steps = new Stack<>();
    }

    String makeStep(int step, StringBuilder stringBuilder) {
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

    @Override
    public void start() {
        isForward();
        print();
    }

    public void print() {
        System.out.println(this.toString());
    }
}
