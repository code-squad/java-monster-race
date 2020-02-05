import domain.Flying;
import org.junit.Test;

public class FlyingTest {

    @Test
    public void createFlying(){
        Flying flying = new Flying("포비");
        flying.attempt(10);
        flying.isForward();
        flying.forward();
    }
}
