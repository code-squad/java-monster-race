package game;

import java.util.ArrayList;
import java.util.List;

public class Reception {
    public static List<Monster> registerParticipants(int totalParticipants) {
        List<Monster> participants = new ArrayList<>();

        showMenu();
        InputInterface inputInterface = InputInterface.getInstance();
        for(int i=0; i<totalParticipants; i++) {
            String[] infos = inputInterface.getTokens(2);
            participants.add(Monster.of(infos));
        }

        return participants;
    }

    private static void showMenu() {
        System.out.println("경주할 몬스터 이름과 종류를 입력하세요.");
        System.out.println("ex)");
        System.out.println("크롱, 달리기");
        System.out.println("포비, 비행");
        System.out.println("호눅스, 에스퍼");
    }
}
