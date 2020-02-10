import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RandomNumber {
    private Random random;

    public RandomNumber(Random random) {
        this.random = random;
    }

    public int getRandom() {
        return random.nextInt();
    }
}

class DeterministicRandom extends Random {
    int sequentialNum = 0;

    public DeterministicRandom() {
        super();
    }

    @Override
    public int nextInt() {
        return sequentialNum++;
    }
}

public class RandomTest {
    RandomNumber randomNumber;

    @BeforeEach
    public void 랜덤숫자생성() {
        DeterministicRandom deterministicRandom = new DeterministicRandom();
        randomNumber = new RandomNumber(deterministicRandom);

    }

    @Test
    public void 랜덤숫자() {
        assertEquals(0, randomNumber.getRandom());
        assertEquals(1, randomNumber.getRandom());
        assertEquals(2, randomNumber.getRandom());
        assertEquals(3, randomNumber.getRandom());
        assertEquals(4, randomNumber.getRandom());
        assertEquals(5, randomNumber.getRandom());

    }
}
