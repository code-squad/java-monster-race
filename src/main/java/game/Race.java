package game;

import java.util.List;

// 게임 전체 로직을 진행하는 역할
public class Race {
    private Rule rule = new Rule();

    // 게임을 시작한다.
    public void start() {
        rule.setRule();
        List<Monster> participants = Reception.registerParticipants(rule.getTotalParticipant());

        System.out.println("\n경기를 시작합니다.");
        for(int round = 0; round<rule.getTotalRound(); round++) {
            playRound(participants);
            Dashboard.displayCurrent(round, participants);
        }
        Dashboard.displayResult(participants);
    }

    private void playRound(List<Monster> participants) {
        for(Monster participant: participants) {
            participant.move();
        }
    }
}
