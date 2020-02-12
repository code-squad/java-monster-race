package game;

import java.util.ArrayList;
import java.util.List;

// 게임 전체 로직을 진행하는 역할
public class Race {
    private Rule rule = new Rule();

    // 게임을 시작하기 위해 필요한 정보를 사용자로부터 초기화한다.
    public void setRule() {
        rule.setRule();
    }

    // 게임을 시작한다.
    public void start() {
        System.out.println("\n경기를 시작합니다.");
        List<Monster> participants = getMonsters();

        for(int round = 0; round<rule.getTotalRound(); round++) {
            playRound(participants);
            displayInfo(round, participants);
        }
    }

    private List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();
        for(int i=0; i<rule.getTotalParticipant(); i++) {
            monsters.add(new Monster());
        }

        return monsters;
    }

    private void playRound(List<Monster> participants) {
        for(Monster participant: participants) {
            participant.move();
        }
    }

    // 시합결과를 출력한다.
    private void displayInfo(int round, List<Monster> participants) {
        Dashboard.displayResult(round, participants);
    }
}
