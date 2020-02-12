package game;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// 경기 정보를 표준 출력을 통해 출력하는 책임이 있다.
public class Dashboard {
    private static final String ROUND_MESSAGE = "----%d round----\n";
    private static final String CURRENT_MESSAGE = "%s: %s\n";
    private static final String RESULT_MESSAGE = "축하합니다! %s가 몬스터 레이스에서 우승했습니다.\n";
    private static final String NOT_HOLD_MESSAGE = "이번 경기는 참가자가 없어 쉽니다.\n";

    public static void displayCurrent(int round, List<Monster> monsters) {
        System.out.printf(ROUND_MESSAGE, round+1);
        for(Monster monster: monsters){
            System.out.printf(CURRENT_MESSAGE, monster, monster.drawDistance());
        }
        System.out.println();
    }

    public static void displayResult(List<Monster> monsters) {
        Optional<Monster> optional = monsters.stream().max(Comparator.comparing(Monster::getDistance));

        if(optional.isPresent()) {
            Monster winner = optional.get();
            System.out.printf(RESULT_MESSAGE, winner);
        } else {
            System.out.println(NOT_HOLD_MESSAGE);
        }
    }
}
