import java.util.Random;

public class Monster {
    private String name;
    private String type;

    private boolean getRandom() {
        Random random = new Random();
        return random.nextInt(10) > 4;
    }

    public void run(int count) {
        while (count > 0) {
            runOrStop();
            count--;
        }
        System.out.println("");
    }

    public void runOrStop() {
        if (getRandom())
            System.out.print("-");

    }
}
