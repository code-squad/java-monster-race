import domain.Flying;
import domain.Psychic;
import domain.Running;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class RandomRunner extends Random {

    public RandomRunner() {
        super();
    }

    @Override
    public int nextInt(int bound) {
        return 5;
    }
}


public class MonsterTest {

    String crong = "크롱";
    String jk = "JK";
    String honux = "호눅스";
    int tryCount = 10;

    Running running;
    Flying flier;
    Psychic psychic;
    RandomNumber randomNumber;

    @BeforeEach
    public void 몬스터객체생성() {
        running = new Running(crong);
        flier = new Flying(jk);
        psychic = new Psychic(honux);

    }

    @Test
    public void 몬스터이름체크() {
        assertEquals(crong, running.getName());
        assertEquals(jk, flier.getName());
        assertEquals(honux, psychic.getName());
    }


    @Test
    public void 게임시도횟수() {
        running.attempt(tryCount);
        flier.attempt(tryCount);
        psychic.attempt(tryCount);

        assertThat(running.getSteps().size()).isEqualTo(tryCount);
        assertThat(flier.getSteps().size()).isEqualTo(tryCount);
        assertThat(psychic.getSteps().size()).isEqualTo(tryCount);

    }

    @Test
    public void 달리기랜덤전진() {
        RandomRunner randomRunner = new RandomRunner();
        running.attempt(randomRunner, tryCount);
        running.forward();
        assertThat(running.getStep()).isEqualTo(10);
    }


}
