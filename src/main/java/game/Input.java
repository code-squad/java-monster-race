package game;

import java.util.Scanner;

// 게임 진행에 필요한 정보를 사용자로부터 입력을 얻는다.
// 유효한 정보를 얻는다.
public class Input {
    private final static int ERROR_CODE = -1;
    private final Scanner sc;

    Input() {
        sc = new Scanner(System.in);
    }

    public int getMonsterCount() {
        System.out.println("몇 명의 몬스터가 경주하나요?");
        return getInt();
    }

    public int getRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return getInt();
    }

    private int getInt() {
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
}
