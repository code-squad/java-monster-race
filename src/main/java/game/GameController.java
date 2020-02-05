package game;

import java.util.Scanner;

/**
 * 사용자 입력 인터페이스
 * 사용자 입력과 model 함수를 매핑한다.
 * 연산 후 적절하게 응답한다.
 */
public class GameController {
    private static final int ERROR_INPUT = 0;
    private static final Scanner sc = new Scanner(System.in);

    private MonsterModel monsterModel;
    private int nRound;

    GameController(MonsterModel monsterModel) {
        this.monsterModel = monsterModel;
    }

    // 몬스터 수를 입력 받는다.
    public void getMonsterCount() {
        System.out.println("몬스터는 모두 몇 마리인가요?");

        int nMonster = getInt();
        for (int i=0; i<nMonster; i++) monsterModel.add();
    }

    // 라운드 반복 횟수를 입력 받는다.
    public void getRoundCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        nRound = getInt();
    }

    // 경기를 시작한다.
    public void startRacing() {
        for(int i=0; i<nRound; i++)
            monsterModel.updateMonsterDistance();
    }

    // 결과를 출력한다.
    public void printResult() {
        System.out.println("<실행 결과>");
        MonsterView.printResult(monsterModel.getMonsterList());
    }

    private int getInt() {
        int rValue;

        do {
            try {
                rValue = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                rValue = ERROR_INPUT;
                System.out.println("입력값을 확인해주세요.");
            }
        }while(rValue == ERROR_INPUT);

        return rValue;
    }
}
