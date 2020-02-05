import domain.Runner;
import org.junit.Test;

public class RunnerTest {

    @Test
    public void createRunner(){
        Runner runner = new Runner("크롱");
        runner.attempt(10);
        runner.isForward();
        runner.forward();
    }
}
