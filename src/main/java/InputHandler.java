import java.security.InvalidParameterException;
import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getMonsterNumber() {
        System.out.println("몬스터는 모두 몇 마리인가요?");
        return checkException();
    }

    public int getTrials() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return checkException();
    }

    private int checkException() {
        try {
            int inputValue = Integer.parseInt(scanner.nextLine());
            if (inputValue < 1) {
                throw new InvalidParameterException();
            }
            return inputValue;
        } catch (NumberFormatException | InvalidParameterException e) {
            System.out.println("1 이상의 값을 입력하세요");
            return checkException();
        }
    }
    public void close() {
        if (scanner != null) scanner.close();
    }
}