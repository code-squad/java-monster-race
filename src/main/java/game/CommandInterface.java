package game;

import java.util.Scanner;

// 사용자로부터 입력을 얻는 책임이 있다.
public class CommandInterface {
    private static CommandInterface instance;

    private final static int ERROR_CODE = -1;
    private final static String ERROR_MESSAGE = "입력 형식을 확인해주세요.";
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
                System.out.println(ERROR_MESSAGE);
                input = ERROR_CODE;
            }
        }

        return input;
    }

    public String[] getTokens(int tokenCount) {
        String[] tokens = null;

        while(tokens == null) {
            try {
                // greedy 공백,greedy 공백의 패턴으로 문자를 잘라라.
                tokens = sc.nextLine().trim().split("\\s*,\\s*");
                if(tokens.length != tokenCount) {
                    throw new Exception(ERROR_MESSAGE);
                }
            } catch (Exception e) {
                System.out.println(ERROR_MESSAGE);
                tokens = null;
            }
        }

        return tokens;
    }

    private CommandInterface() {
        sc = new Scanner(System.in);
    }
}
