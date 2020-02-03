package MonsterRace_Step1;

import java.util.ArrayList;
import java.util.List;

public class Main {
//    초간단 몬스터 경주 게임을 구현한다.
//    주어진 횟수 동안 n마리의 몬스터는 전진 또는 멈출 수 있다.
//    사용자는 몇 마리의 몬스터로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
//    전진하는 조건은 0에서 9까지 random값 중 4이상이면 전진한다.
//    몬스터의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

    private int monsterCnt = 0;
    private int moveCnt = 0;
    private List<Monster> monsterList = new ArrayList<>();

    public int getMonsterCnt() {
        return monsterCnt;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void setMonsterCnt(int monsterCnt) {
        this.monsterCnt = monsterCnt;
    }

    public void setMoveCnt(int moveCnt) {
        this.moveCnt = moveCnt;
    }

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Input in = new Input();
        Make mk = new Make();
        Output out = new Output();

        in.inputMonster(main);
        mk.makeMonster(main);
        out.resultGame(main);
    }
}
