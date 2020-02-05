import domain.Flying;
import domain.Psychic;
import domain.Runner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewMonsterTest {

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
    public void inputAttemptCount() {
        runner.attempt(attemptCount);
        flying.attempt(attemptCount);
        psychic.attempt(attemptCount);

        assertEquals(10, runner.getIsForwardStack().size());
        assertEquals(10, flying.getIsForwardStack().size());
        assertEquals(10, psychic.getIsForwardStack().size());

    }
}
