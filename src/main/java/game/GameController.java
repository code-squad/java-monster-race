package game;

import java.util.ArrayList;
import java.util.List;

// 게임 전체 로직을 진행하는 역할
public class GameController {
    private Input input;
    private Output output;
    private List<Monster> monsters;
    private int nRound;

    GameController() {
        input = new Input();
        output = new Output();
        monsters = new ArrayList<>();
        nRound = 0;
    }

    // 게임을 시작하기 위해 필요한 정보를 사용자로부터 초기화한다.
    public void initialize() {
        int nMonster = input.getMonsterCount();
        for(int i=0; i<nMonster; i++) {
            monsters.add(new Monster());
        }
        nRound = input.getRoundCount();
    }

    // 게임을 시작한다.
    public void race() {
        for(Monster monster: monsters) {
            monster.move();
        }
    }

    // 시합결과를 출력한다.
    public void displayResult() {
        output.displayResult(monsters);
    }
}
