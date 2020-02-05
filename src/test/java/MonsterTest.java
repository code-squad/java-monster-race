import domain.Flying;
import domain.Psychic;
import domain.Runner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterTest {

    String crong = "크롱";
    String jk = "JK";
    String honux = "호눅스";
    int attemptCount = 10;

    Runner runner;
    Flying flying;
    Psychic psychic;

    @Before
    public void createObject() {
        runner = new Runner(crong);
        flying = new Flying(jk);
        psychic = new Psychic(honux);
    }

    @Test
    public void runnerForward() {
        runner.attempt(attemptCount);
        assertEquals(10, runner.getIsForwardStack().size());

        runner.run();
    }

    @Test
    public void flyingForward() {
        flying.attempt(attemptCount);
        assertEquals(10, flying.getIsForwardStack().size());

        flying.run();
    }

    @Test
    public void psychicForward() {
        psychic.attempt(attemptCount);
        assertEquals(10, psychic.getIsForwardStack().size());

        psychic.run();
    }


}
