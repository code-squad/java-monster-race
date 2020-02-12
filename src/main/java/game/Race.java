package game;

import java.util.ArrayList;
import java.util.List;

// 게임 전체 로직을 진행하는 역할
public class Race {
    private Rule rule = new Rule();
    private List<Monster> participants = new ArrayList<>();

    // 게임을 시작한다.
    public void start() {
        setRule();
        enterParticipants();

        System.out.println("\n경기를 시작합니다.");
        for(int round = 0; round<rule.getTotalRound(); round++) {
            playRound();
            Dashboard.displayCurrent(round, participants);
        }
        Dashboard.displayResult(participants);
    }

    private void setRule() {
        rule.setRule();
    }

    private void enterParticipants() {
        participants.clear();
        participants.addAll(Reception.registerParticipants(rule.getTotalParticipant()));
    }

    private void playRound() {
        for(Monster participant: participants) {
            participant.move();
        }
    }
}
