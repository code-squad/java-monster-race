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
    public void countAttempt() {
        runner.attempt(attemptCount);
        assertEquals(attemptCount, runner.getSteps().size());

        flying.attempt(attemptCount);
        assertEquals(attemptCount, flying.getSteps().size());

        psychic.attempt(attemptCount);
        assertEquals(attemptCount, psychic.getSteps().size());

    }

    @Test
    public void getName(){
        assertEquals(crong, runner.getName());
        assertEquals(jk, flying.getName());
        assertEquals(honux, psychic.getName());
    }


}
