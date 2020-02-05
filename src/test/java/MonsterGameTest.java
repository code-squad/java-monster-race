import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MonsterGameTest {

    @Test
    @RepeatedTest(5)
    void randomNumber() {
        MonsterGame monsterGame = new MonsterGame();
        int randomNumber = monsterGame.randomNumber();
        assertTrue(randomNumber >= monsterGame.MIN_RANDOM_NUMBER && randomNumber <= monsterGame.MAX_RANDOM_NUMBER);
    }
}