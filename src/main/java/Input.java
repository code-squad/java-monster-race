import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public void opening() {
        System.out.println("<스릴 만점! 몬스터 경주>");
    }

    public int getCountOfMonsters() {
        System.out.println("출전할 몬스터는 몇 마리?");
        return getPositiveInt();
    }

    public int getRounds() {
        System.out.println("몇 라운드?");
        return getPositiveInt();
    }

    public void closeScanner() {
        if(scanner != null)
            scanner.close();
    }

    private int getPositiveInt() {
        int input;
        try{
            input = Integer.parseInt(scanner.nextLine());
            if(input <= 0)
                throw new InvalidRangeException("유효 범위에서 벗어난 입력값입니다.");
        } catch(NumberFormatException | InvalidRangeException e) {
            System.out.println(e.getMessage());
            input = getPositiveInt();
        }
        return input;
    }

    private static class InvalidRangeException extends RuntimeException {

        public InvalidRangeException(String message) {
            super(message);
        }
    }
}
