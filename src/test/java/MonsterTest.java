import domain.Flying;
import domain.Psychic;
import domain.Running;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class MonsterTest {

    String crong = "크롱";
    String jk = "JK";
    String honux = "호눅스";
    int tryCount = 10;

    Running running;
    Flying flier;
    Psychic psychic;

    @BeforeEach
    public void 몬스터객체생성() {
        running = new Running(crong);
        flier = new Flying(jk);
        psychic = new Psychic(honux);
    }

    @Test
    public void 게임시도횟수() {
        running.attempt(tryCount);
        assertThat(running.getSteps().size()).isEqualTo(tryCount);

//        assertEquals(tryCount, running.getSteps().size());
//
//        flier.attempt(tryCount);
//        assertEquals(tryCount, flier.getSteps().size());
//
//        psychic.attempt(tryCount);
//        assertEquals(tryCount, psychic.getSteps().size());

    }

    @Test
    public void getName() {
        assertEquals(crong, running.getName());
        assertEquals(jk, flier.getName());
        assertEquals(honux, psychic.getName());
    }


}
