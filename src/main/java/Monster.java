import java.util.Random;

public class Monster {
    private static final int FORWARD_RANGE = 9;
    private static final int FORWARD_CONDITION = 4;
    private static final String FORWARD = "-";

    private String step;
    private Random random;

    public Monster(int count) {
        this.step = "";
        this.random = new Random();
        forWard(count);
    }

    private void forWard(int count){
        for (int start = 0; start < count; start++) {
            int isForward = random.nextInt(FORWARD_RANGE);
            if(isForward >= FORWARD_CONDITION) step += FORWARD;
        }
    }

    public void run() {
        System.out.println(step);
    }
}

