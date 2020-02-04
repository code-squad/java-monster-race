import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MonsterTest {

    @Test
    public void monsterCreate(){
        List<Monster> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(new Monster(5));
        }

        for (int i = 0; i < 3; i++) {
            list.get(i).run();
        }
    }
}
