package game;

import java.util.Scanner;

// 게임 진행에 필요한 정보를 사용자로부터 입력을 얻는다.
// 유효한 정보를 얻는다.
public class Input {
    private final Scanner sc;

    Input() {
        sc = new Scanner(System.in);
    }

    public int getMonsterCount() {
        return 0;
    }

    public int getRoundCount() {
        return 0;
    }
}
