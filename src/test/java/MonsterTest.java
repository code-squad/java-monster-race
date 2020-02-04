import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


import static org.junit.Assert.*;

public class MonsterTest {

    int monsterCount = 3;
    int attemptCount = 5;
    Game game = new Game();

    @Before
    public void monsterCount() {
        InputStream in = new ByteArrayInputStream(String.valueOf(monsterCount).getBytes());
        System.setIn(in);
        game.createScanner();
        game.inputMonsterCount();

        assertEquals(game.monsterCount, this.monsterCount);

    }

    @Before
    public void attemptCount() {
        InputStream in = new ByteArrayInputStream(String.valueOf(attemptCount).getBytes());
        System.setIn(in);
        game.createScanner();
        game.inputAttemptCount();

        assertEquals(game.attemptCount, this.attemptCount);

    }

    @Test
    public void createMonster() {
        game.startGame();
    }

}
