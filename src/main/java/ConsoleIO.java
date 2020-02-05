import java.util.Scanner;

public class ConsoleIO {
    private static Scanner scanner = new Scanner(System.in);

    public static void printLine(String line){
        System.out.println(line);
    }

    public static void renderTraces(StringBuilder traces){
        System.out.println(traces);
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
