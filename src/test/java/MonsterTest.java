import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


import static org.junit.Assert.*;

public class MonsterTest {

    int monsterCount = 3;
    int attemptCount = 5;

    @Test
    public void monsterCount() {
        InputStream in = new ByteArrayInputStream(String.valueOf(monsterCount).getBytes());
        Game game = new Game();
        System.setIn(in);
        game.createScanner();
        game.inputMonsterCount();

        assertEquals(game.monsterCount, this.monsterCount);

    }

    @Test
    public void attemptCount() {
        InputStream in = new ByteArrayInputStream(String.valueOf(attemptCount).getBytes());
        Game game = new Game();
        System.setIn(in);
        game.createScanner();
        game.inputAttemptCount();

    }

}
