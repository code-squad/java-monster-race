package MonsterRace;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class RaceTest {
    Race race;
    int monsterCnt;
    int roundCnt;
    String inputString;

    InputStream in;

    @BeforeEach
    void setUp() {

    }

    @Test
    void resultsOfMatch() {
        monsterCnt = 8;
        roundCnt = 9;
        inputString = monsterCnt + "\n" + roundCnt + "\n";

        in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);

        race = new Race();
        race.startRace();
        race.resultsOfMatch();
    }
}