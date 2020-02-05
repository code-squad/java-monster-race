import domain.Psychic;
import org.junit.Test;

public class PsychicTest {

    @Test
    public void createPsychic(){
        Psychic psychic = new Psychic("호눅스");
        psychic.attempt(10);
        psychic.isForward();
        psychic.forward();
    }
}
