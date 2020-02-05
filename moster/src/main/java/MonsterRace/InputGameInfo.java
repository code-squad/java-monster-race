package MonsterRace;

import java.util.Scanner;

public class InputGameInfo {

    public void getGameInfo(Game game) {
        Scanner scanner = new Scanner(System.in);
        String beforeMonsterCnt = "<스릴만점 건전한 몬스터 경주>\n" + "몬스터는 모두 몇 마리인가요?";
        String beforeGameCnt = "시도할 회수는 몇 회 인가요?";

        System.out.println(beforeMonsterCnt);
        game.setMonsterCnt(scanner.nextLine());
        System.out.println(beforeGameCnt);
        game.setGameCnt(scanner.nextLine());
        scanner.close();
    }
}
