package game;

public class Rule {
    private int totalRound = 0;
    private int totalParticipant = 0;

    public void setRule() {
        InputInterface inputInterface = InputInterface.getInstance();

        System.out.println("몬스터는 모두 몇 마리인가요?");
        setTotalParticipant(inputInterface.getInt());

        System.out.println("시도할 횟수는 몇 회 인가요");
        setTotalRound(inputInterface.getInt());
    }

    public int getTotalRound() {
        return totalRound;
    }

    public int getTotalParticipant() {
        return totalParticipant;
    }

    private void setTotalRound(int totalRound) {
        this.totalRound = totalRound;
    }

    private void setTotalParticipant(int totalParticipant) {
        this.totalParticipant = totalParticipant;
    }
}
