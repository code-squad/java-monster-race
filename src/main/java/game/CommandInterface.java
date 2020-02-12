package game;

import java.util.Scanner;

// 사용자로부터 입력을 얻는 책임이 있다.
public class CommandInterface {
    private static CommandInterface instance;

    private final static int ERROR_CODE = -1;
    private final Scanner sc;

    public static CommandInterface getInstance() {
        if(instance == null) {
            instance = new CommandInterface();
        }
        return instance;
    }

    public int getInt() {
        int input = ERROR_CODE;

        while(input == ERROR_CODE) {
            try {
                input = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("입력 형식을 확인해주세요.");
                input = ERROR_CODE;
            }
        }

        return input;
    }

    private CommandInterface() {
        sc = new Scanner(System.in);
    }
}
