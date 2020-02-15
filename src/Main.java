import controller.Controller;
import view.*;

public class Main {
    public static void main(String[] args) {
        InputView input = new InputView();
        input.initializeRace();

        Controller.race();

        OutputView output = new OutputView();
        output.result();
    }
}
