import domain.Flying;
import domain.Psychic;
import domain.Running;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterTest {

    String crong = "크롱";
    String jk = "JK";
    String honux = "호눅스";
    int attemptCount = 10;

    Running running;
    Flying flier;
    Psychic psychic;

    @Before
    public void createObject() {
        running = new Running(crong);
        flier = new Flying(jk);
        psychic = new Psychic(honux);
    }

    @Test
    public void countAttempt() {
        running.attempt(attemptCount);
        assertEquals(attemptCount, running.getSteps().size());

        flier.attempt(attemptCount);
        assertEquals(attemptCount, flier.getSteps().size());

        psychic.attempt(attemptCount);
        assertEquals(attemptCount, psychic.getSteps().size());

    }

    @Test
    public void getName(){
        assertEquals(crong, running.getName());
        assertEquals(jk, flier.getName());
        assertEquals(honux, psychic.getName());
    }


}
