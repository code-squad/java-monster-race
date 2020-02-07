import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public int getCountOfMosters() {
        System.out.println("출전할 몬스터는 몇 마리?");
        return getPositiveInt();
    }

    public int getRounds() {
        System.out.println("몇 라운드?");
        return getPositiveInt();
    }

    public void closeScanner(){
        if(scanner != null)
            scanner.close();
    }

    private int getPositiveInt() {
        int input = 0;
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

    private class InvalidRangeException extends RuntimeException {

        public InvalidRangeException(String message) {
            super(message);
        }
    }
}
