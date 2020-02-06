import java.util.Scanner;

public class ConsoleIO {
    private static Scanner scanner = new Scanner(System.in);

    public static void printLine(CharSequence line){
        System.out.println(line);
    }

    public static int printLineReturnInt(String line){
        printLine(line);
        return getInputDataByInt();
    }

    public static int getInputDataByInt(){
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
}
