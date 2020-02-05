package domain;

import java.util.Random;
import java.util.Stack;

public abstract class Monster implements Move {
    protected static final int FORWARD_RANGE = 10;
    protected static final int FORWARD = 1;

    protected String name;
    protected int step;
    protected Random random;
    protected Stack<Integer> isForwardStack;

    public Monster(String name) {
        this.name = name;
        this.random = new Random();
        this.isForwardStack = new Stack<>();
    }

    private String makeStep() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < step; i++) sb.append('-');
        return sb.toString();
    }

    public int getStep() {
        return step;
    }

    public Stack<Integer> getIsForwardStack() {
        return isForwardStack;
    }


    @Override
    public void attempt(int attemptCount) {
        if (attemptCount == 0) return;
        isForwardStack.add(random.nextInt(FORWARD_RANGE));
        attempt(attemptCount - FORWARD);
    }

    @Override
    public void forward() {
        System.out.println(this.toString());
    }

    @Override
    public void run() {
        isForward();
        forward();
    }

    @Override
    public String toString() {
        String className = getClass().getName();
        String type = "";
        if (className.equals("domain.Runner")) type = "달리기";
        if (className.equals("domain.Flying")) type = "비행";
        if (className.equals("domain.Psychic")) type = "에스퍼";

        return this.name + " " + "[" + type + "]" + " : " + makeStep();
    }
}
