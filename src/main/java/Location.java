import java.util.Random;

public class Location {
    private int trials;
    private int monsters;

    Location(int trials, int monsters) {
        this.trials = trials;
        this.monsters = monsters;
    }

    public void showStatus() {
        for (int i = 0; i < monsters; i++) {
            System.out.println(computeLocation(trials));
        }
    }

    private boolean randomMove() {
        Random generator = new Random();
        int random = generator.nextInt(10);
        return random >= 4;
    }

    public String computeLocation(int trials) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < trials; i++) {

            if (randomMove()) {
                stringBuffer.append("-");
            }
        }
        return stringBuffer.toString();
    }
}