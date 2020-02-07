import java.util.Scanner;

public class ConsoleIO {
    private static Scanner scanner = new Scanner(System.in);

    public static void printLine(CharSequence line){
        System.out.println(line);
    }

    public static int print(String line){
        printLine(line);
        return getPositiveInt();
    }

    public static int getPositiveInt(){
        int input;
        try{
            input = Integer.parseInt(scanner.nextLine());
        } catch(NumberFormatException e){
            input = 0;
        }
        return input;
    }

    public static void close(){
        if(scanner != null)
            scanner.close();
    }

    private class InvalidRangeException extends RuntimeException{
        public InvalidRangeException() {
        }

        public InvalidRangeException(String message) {
            super(message);
        }
    }
}
