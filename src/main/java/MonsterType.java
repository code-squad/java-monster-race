import java.util.List;
import java.util.Random;

public class MonsterType {
    int numberOfRounds;

    public MonsterType(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public void matchAllType(List<Monster> monsters) {
        for(Monster each : monsters) {
            matchType(each);
        }
    }

    public void matchType(Monster monster) {
            String type = monster.Type();
            switch(type) {
                case "달리기":
                    running(monster);
                    break;
                case "비행":
                    flying(monster);
                    break;
                case "에스퍼":
                    esper(monster);
                    break;
            }
        }

    public void running(Monster monster) {
        Random random = new Random();
        for(int i = 0 ; i < numberOfRounds; i++) {
            int random_int = random.nextInt(10);
            if (random_int > 3) {
                monster.addMoves(1);
            }
        }
    }

    public void flying(Monster monster) {
        Random random = new Random();
        for(int i = 0 ; i < numberOfRounds; i++) {
            int random_int = random.nextInt(10 );
            if (random_int > 5) {
                monster.addMoves(3);
            }
        }
    }

    public void esper(Monster monster) {
        Random random = new Random();
        for(int i = 0 ; i < numberOfRounds; i++) {
            int random_int = random.nextInt(10) ;
            if (random_int > 8) {
                monster.addMoves(random.nextInt(99) + 1);
            }
        }
    }
}
