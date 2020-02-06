import java.util.Random;

public class Location {

    public int computeLocation(int tryNumber) {
        int point = 0;
        Random generator = new Random();

        for (int i = 0; i < tryNumber; i++) {
            int random = generator.nextInt(10);

            if (random >= 4) {
                point++;
            }
        }
        return point;
    }
}
