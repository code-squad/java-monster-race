import java.util.Random;

public class Type {
    private String running;
    private String flying;
    private String esper;

    public void matchType(Monster monster) {
        if (monster.type.equals("running")) {
            Random random = new Random();
            int randomInt = random.nextInt(10) + 1 ;
            if (randomInt > 4) {
                monster.oneStepForward();
            }
            monster.moves +=
        }
    }


}
